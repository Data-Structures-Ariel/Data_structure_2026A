package Week06;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;


    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        // Your implementation
        return false;
    }

    @Override
    public Iterator<E> iterator() {
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
    public boolean add(E e) {
        if (size == elementData.length)
            init();

        elementData[size++] = e;


        return true;
    }

    private void init() {
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;
        E item;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false;

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
        // Your implementation

    }

    @Override
    public E get(int index) {
        // Your implementation

        return null;
    }

    @Override
    public E set(int index, E element) {
        // Your implementation

        return null;
    }

    @Override
    public void add(int index, E element) {
        // Your implementation

    }

    @Override
    public E remove(int index) {
        // Your implementation

        return null;
    }

    @Override
    public int indexOf(Object o) {
        // Your implementation

        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        // Your implementation

        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
