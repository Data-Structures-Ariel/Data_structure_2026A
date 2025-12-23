import cv2
import mediapipe as mp
import numpy as np
import pygame
import random

# --------- HAND TRACKER (MediaPipe) ----------
mp_hands = mp.solutions.hands

# --------- GAME SETTINGS ----------
WIDTH = 640
HEIGHT = 480

BIRD_X = 150
BIRD_RADIUS = 20

PIPE_WIDTH = 80
PIPE_GAP = 110
PIPE_SPEED = 10
PIPE_MIN_MARGIN = 100  # שלא יהיה חור קרוב מדי לקצה

BACKGROUND_COLOR = (15, 15, 40)
PIPE_COLOR = (0, 200, 0)
BIRD_COLOR = (255, 220, 0)
TEXT_COLOR = (255, 255, 255)
GAME_OVER_COLOR = (220, 50, 50)

FPS = 60
SMOOTHING_ALPHA = 0.5  # 0..1 - ככל שקטן יותר התנועה חלקה/איטית יותר


def create_pipe():
    """יוצר צינור חדש עם חור בגובה רנדומלי."""
    gap_y = random.randint(PIPE_MIN_MARGIN, HEIGHT - PIPE_MIN_MARGIN)
    return {"x": WIDTH + 50, "gap_y": gap_y}


def reset_game():
    """איפוס מצב המשחק."""
    bird_y = HEIGHT // 2
    smoothed_y = float(bird_y)
    pipes = [create_pipe()]
    score = 0
    game_over = False
    return bird_y, smoothed_y, pipes, score, game_over


def main():
    # ---------- Init Pygame ----------
    pygame.init()
    screen = pygame.display.set_mode((WIDTH, HEIGHT))
    pygame.display.set_caption("Flappy Bird - Hand Controlled")
    clock = pygame.time.Clock()
    font = pygame.font.SysFont(None, 36)
    big_font = pygame.font.SysFont(None, 64)

    # ---------- Init Camera ----------
    cap = cv2.VideoCapture(0)

    # ---------- Init MediaPipe ----------
    with mp_hands.Hands(
        max_num_hands=1,
        min_detection_confidence=0.5,
        min_tracking_confidence=0.5,
    ) as hands:

        bird_y, smoothed_y, pipes, score, game_over = reset_game()
        running = True

        while running:
            clock.tick(FPS)

            # ----- Handle Pygame events -----
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    running = False

            # ----- Read camera frame -----
            ret, frame = cap.read()
            if not ret:
                print("Camera read failed")
                break

            frame = cv2.flip(frame, 1)
            rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            rgb = np.ascontiguousarray(rgb)

            result = hands.process(rgb)

            # ----- Hand / Finger detection -----
            finger_detected = False
            finger_norm_y = 0.5  # ברירת מחדל - מרכז

            if result.multi_hand_landmarks:
                lm = result.multi_hand_landmarks[0].landmark
                # landmark 8 = index fingertip, ערך בין 0..1
                finger_norm_y = lm[8].y
                finger_detected = True

            # ----- Update bird position (smooth) -----
            if finger_detected:
                target_y = finger_norm_y * HEIGHT
                # החלקת תנועה (Exponential Moving Average)
                smoothed_y = smoothed_y + SMOOTHING_ALPHA * (target_y - smoothed_y)
            else:
                # אם לא רואים יד - לאזיז מעט למטה
                smoothed_y = smoothed_y + 1.5

            # גבולות מסך
            if smoothed_y < BIRD_RADIUS:
                smoothed_y = BIRD_RADIUS
            if smoothed_y > HEIGHT - BIRD_RADIUS:
                smoothed_y = HEIGHT - BIRD_RADIUS

            bird_y = int(smoothed_y)

            # ----- Update pipes & collisions -----
            if not game_over:
                # הזזת צינורות
                for pipe in pipes:
                    pipe["x"] -= PIPE_SPEED

                # צינור חדש כשצריך
                if pipes and pipes[-1]["x"] < WIDTH - 250:
                    pipes.append(create_pipe())

                # מחיקת צינורות שעברו
                pipes = [p for p in pipes if p["x"] > -PIPE_WIDTH - 10]

                # בדיקת התנגשות + ניקוד
                for pipe in pipes:
                    x = pipe["x"]
                    gap_y = pipe["gap_y"]

                    # אם העיגול בטווח אופקי של הצינור
                    if BIRD_X + BIRD_RADIUS > x and BIRD_X - BIRD_RADIUS < x + PIPE_WIDTH:
                        gap_top = gap_y - PIPE_GAP // 2
                        gap_bottom = gap_y + PIPE_GAP // 2
                        # אם הציפור *לא* בתוך החור
                        if not (gap_top < bird_y < gap_bottom):
                            game_over = True

                    # ניקוד: כשהציפור "עברה" את הצינור
                    if x + PIPE_WIDTH == BIRD_X:
                        score += 1

            # ----- Draw everything -----
            screen.fill(BACKGROUND_COLOR)

            # Draw pipes
            for pipe in pipes:
                x = int(pipe["x"])
                gap_y = pipe["gap_y"]
                gap_top = gap_y - PIPE_GAP // 2
                gap_bottom = gap_y + PIPE_GAP // 2

                # צינור עליון
                top_rect = pygame.Rect(x, 0, PIPE_WIDTH, gap_top)
                pygame.draw.rect(screen, PIPE_COLOR, top_rect)

                # צינור תחתון
                bottom_rect = pygame.Rect(x, gap_bottom, PIPE_WIDTH, HEIGHT - gap_bottom)
                pygame.draw.rect(screen, PIPE_COLOR, bottom_rect)

            # Draw bird
            pygame.draw.circle(screen, BIRD_COLOR, (BIRD_X, bird_y), BIRD_RADIUS)

            # Draw score
            score_surf = font.render(f"Score: {score}", True, TEXT_COLOR)
            screen.blit(score_surf, (10, 10))

            # Game over text
            if game_over:
                go_surf = big_font.render("GAME OVER", True, GAME_OVER_COLOR)
                go_rect = go_surf.get_rect(center=(WIDTH // 2, HEIGHT // 2 - 30))
                screen.blit(go_surf, go_rect)

                info_surf = font.render("Raise finger high to restart", True, TEXT_COLOR)
                info_rect = info_surf.get_rect(center=(WIDTH // 2, HEIGHT // 2 + 20))
                screen.blit(info_surf, info_rect)

                # אם האצבע גבוהה (למעלה במסך) → ריסט
                if finger_detected and finger_norm_y < 0.3:
                    bird_y, smoothed_y, pipes, score, game_over = reset_game()

            pygame.display.flip()

    cap.release()
    cv2.destroyAllWindows()
    pygame.quit()


if __name__ == "__main__":
    main()