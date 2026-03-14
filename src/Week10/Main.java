package Week10;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Node<Integer> chain = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
//        print(chain);
//        test(chain);
//        print(chain);

        print(chain);
        first(chain);
        print(chain);
        Stack<Integer> st = new Stack<>();
        boolean bool = equalsSums(st);
    }

    private static boolean equalsSums(Stack<Integer> st) {
        if (st == null || st.isEmpty())
            return false;

        Stack<Integer> copy = copyStack(st);
        int size = sizeStack(st);

        if (size % 2 == 0)
            return false;

        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < size / 2; i++) {
            temp.push(copy.pop());
        }
        int middle = copy.pop();

        while (!copy.isEmpty())
            if (copy.pop() + temp.pop() != middle)
                return false;

        return true;
    }

    private static int sizeStack(Stack<Integer> st) {
        if (st == null)
            return 0;
        Stack<Integer> stTemp = new Stack<>();
        int size = 0;

        while (!st.isEmpty()) {
            stTemp.push(st.pop());
            size++;
        }

        while (!stTemp.isEmpty())
            st.push(stTemp.pop());

        return size;
    }

    private static Stack<Integer> copyStack(Stack<Integer> st) {
        if (st == null)
            return null;
        Stack<Integer> stTemp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        while (!st.isEmpty())
            stTemp.push(st.pop());

        while (!stTemp.isEmpty()) {
            st.push(stTemp.peek());
            copy.push(stTemp.pop());
        }

        return copy;
    }

    private static void test(Node<Integer> chain) {
        chain.setVal(6);
        chain.setNext(new Node<>(5));

        Node<Integer> temp = chain;

        temp.setVal(3);

    }

    private static void print(Node<Integer> chain) {


        while (chain != null) {
            System.out.print(chain.getVal() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    public static void first(Node<Integer> chain) {
        if (chain == null)
            return;

        while (chain != null) {
            Node<Integer> copy = new Node<>(chain.getVal(), chain.getNext());
            chain.setNext(copy);
            chain = copy.getNext();

//            chain.setNext(new Node<>(chain.getVal(),chain.getNext()));
//            chain=chain.getNext().getNext();
        }
    }

    public static void second(Node<Integer> chain) {
        if (chain == null)
            return;
        Node<Integer> copyChain = copy(chain);
        while (chain.hasNext())
            chain = chain.getNext();

        chain.setNext(copyChain);
    }

    public static Node<Integer> copy(Node<Integer> chain) {
        if (chain == null)
            return null;

        Node<Integer> head = new Node(chain.getVal());
        Node<Integer> current = head;
        chain = chain.getNext();

        while (chain != null) {
            current.setNext(new Node<>(chain.getVal()));
            chain = chain.getNext();
            current = current.getNext();
        }
        return head;
    }
}
