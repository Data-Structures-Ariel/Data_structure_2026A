package Week07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        isBalanced(st);

        Queue<Integer> q = new LinkedList<>();



    }

    public static boolean isBalanced(Stack<Integer> st) {
        if (st == null)
            return true;

        Stack<Integer> sTemp = new Stack<>();
        int pCount = 0, nCount = 0, zCount = 0;
        while (!st.isEmpty()) {
            int item = st.pop();
            sTemp.push(item);
            if (item > 0)
                pCount++;
            else if (item < 0)
                nCount++;
            else
                zCount++;
        }

        while (!sTemp.isEmpty())
            st.push(sTemp.pop());


        return nCount == pCount &&  zCount == pCount;
    }
}
