package Week09;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Node<Integer> chain = new Node<>(1);
        System.out.println(chain);

        Node<Integer> ch2 = new Node<>(2);
        System.out.println(ch2);

        chain.setNext(ch2);

        System.out.println(chain);

        Node<Integer> ch3 = new Node<>(3);
        System.out.println(ch3);

        // chain.getNext()== ch2
        System.out.println(ch2);
        System.out.println(chain.getNext());

        ch2.setNext(ch3);
        chain.getNext().setNext(ch3);

        System.out.println(chain);

        System.out.println(chain.getNext().getNext());
        System.out.println(ch3);

        System.out.println(chain);
        insert(chain, 4);
        System.out.println(chain);
        System.out.println("------------------------------Add------------------------------");
        for (int i = 5; i <= 10; i++) {
            add(chain, i);
            System.out.println(chain);
        }

        Node<Integer> head = null;
        add(head, 1);
        System.out.println(head);
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
        insert(arr);
        System.out.println(Arrays.toString(arr));

        head = add(head, 1);
        System.out.println(head);

        head = add(head, 2);
        System.out.println(head);


        for (int i = 3; i < 10; i++) {
            head = add(head, i);
            System.out.println(head);
        }
        Node<Integer> first = null;
        for (int i = 10; i >= 0; i--) {
            first = addFirst(first, i);
            System.out.println(first);
        }
        Node<Integer> newNode = new Node<>(1);
        newNode.setNext(first);

        first = new Node<>(1, first);

        System.out.println(first);

        int cnt = count(first);
        System.out.println(cnt);
        boolean bool = isSort(first);

        System.out.println(bool);
        int even = evenCount(first);

        System.out.println(even);

        isSumChain(first);
    }

    private static boolean isSumChain(Node<Integer> chain) {
        if (chain == null)
            return false;

        int sum = chain.getVal();
        chain = chain.getNext();

        while (chain != null) {

            if (sum != chain.getVal())
                return false;
            sum += chain.getVal();
            chain = chain.getNext();

        }

        return true;
    }

    private static int evenCount(Node<Integer> chain) {

        int count = 0;

        while (chain != null) {
            if (chain.getVal() % 2 == 0)
                count++;
//            count += (chain.getVal() % 2 == 0) ? 1 : 0;

            chain = chain.getNext();
        }
        return count;

    }

    private static boolean isSort(Node<Integer> chain) {
        if (chain == null)
            return false;

        while (chain.hasNext()) {
            if (chain.getVal() > chain.getNext().getVal())
                return false;
            chain = chain.getNext();
        }

        return true;
    }

    private static int count(Node<Integer> chain) {

        int count = 0;

        while (chain != null) {
            count++;
            chain = chain.getNext();
        }
        return count;
    }

    private static void insert(int[] arr) {
        arr[0] = 1;
    }

    private static <E> Node<E> add(Node<E> head, E value) {
        if (head == null) {
            return new Node(value);
        }
        Node<E> temp = head;
        while (temp.hasNext())
            temp = temp.getNext();

        temp.setNext(new Node<>(value));

        return head;
    }

    private static <E> void insert(Node<E> head, E value) {
        if (head == null) {
            return;
        }
        Node<E> temp = head;
        while (temp.hasNext())
            temp = temp.getNext();

        temp.setNext(new Node<>(value));

    }

    //O(n)
    private static <E> Node<E> addLast(Node<E> head, E value) {
        if (head == null) {
            return new Node<>(value);
        }
        head.setNext(addLast(head.getNext(), value));

        return head;

    }

    //O(1)
    private static <E> Node<E> addFirst(Node<E> head, E value) {
        Node<E> first = new Node<>(value);
        if (head == null) {
            return first;
        }
        first.setNext(head);

        return first;

    }

}
