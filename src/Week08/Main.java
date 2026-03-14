package Week08;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Node<Integer> head = new Node<>(1);
        Node<Integer> sec = new Node<>(2);
        head.setNext(sec);

        Node<Integer> t = new Node<>(3);

        Node<Integer> head2 = new Node<>(1, new Node<>(2, t));

    }
}
