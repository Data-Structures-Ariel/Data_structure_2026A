package Week06;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> la = new ArrayList<>() {{
            Random rd = new Random();
            int size = rd.nextInt(20);
            for (int i = 0; i < size; i++) {
                add(rd.nextInt(1, 100));
            }
        }};

        ArrayList<Integer> al = new ArrayList<>();

//        if(la instanceof ArrayList<Integer>)
//            ((ArrayList<Integer>) la).clone();

        ITest it = new ITest() {
            @Override
            public void func() {
                System.out.println("Hello");
            }
        };
        it.func();

        List<Integer> ll = new List<Integer>() {
            public int num = 7;

            @Override
            public int size() {

                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Integer get(int index) {
                return 0;
            }

            @Override
            public Integer set(int index, Integer element) {
                return 0;
            }

            @Override
            public void add(int index, Integer element) {

            }

            @Override
            public Integer remove(int index) {
                return 0;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Integer> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Integer> listIterator(int index) {
                return null;
            }

            @Override
            public List<Integer> subList(int fromIndex, int toIndex) {
                return List.of();
            }
        };
        MyArrayList<Integer> mla = new MyArrayList<>();
        MyArrayList<String> mlaS = new MyArrayList<>();
        System.out.println(mla.size());
        for (int i = 0; i < 110; i++) {
            mla.add(i);
        }
        System.out.println(mla.size());























        mla.add(3);
    }
}
