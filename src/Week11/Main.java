package Week11;

import javax.xml.crypto.NodeSetData;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {


    static void main() {
        sum(10);
        Queue<Integer> q = new LinkedList<>() {{
            for (int i = 1; i <= 5; i++) {
                add(i);
            }
        }};
        Stack<Integer> st = new Stack<>() {{
            for (int i = 1; i <= 5; i++) {
                add(i);
            }
        }};


        System.out.println(q);
        revers(q);
        System.out.println(q);
        System.out.println(revers(q));
        System.out.println(q);

        System.out.println("--------------------------------------------");

        System.out.println(st);
        revers(st);
        System.out.println(st);
        System.out.println(revers(st));
        System.out.println(st);
    }

    private static int revers(Queue<Integer> q) {
        if (q.isEmpty())
            return 0;
        int item = q.poll();
        int ans = revers(q);
        q.add(item + ans);
        return item + ans;
    }


    public static int revers(Stack<Integer> st) {
        return revers(st, new Stack<Integer>());
    }

    private static int revers(Stack<Integer> st, Stack<Integer> temp) {
        if (st.isEmpty())
            return 0;
        int item = st.pop();
        temp.push(item);
        int ans = revers(st);
        st.add(item + ans);
        return item + ans;
    }


    static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }

    int sumIter(int n) {
        Stack<Integer> st = new Stack<>();
        while (n != 0) {
            st.push(n);
            n--;
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}
