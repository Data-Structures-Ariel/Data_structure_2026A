package Week08;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyConstQueue<E> implements Queue<E> {

    private Object[] objects;
    private int size = 0;


    public MyConstQueue() {
        this.objects = new Object[10];
        this.size = 0;

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
        if (isEmpty())
            return false;
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(o))
                return true;


        }
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

//    O(1)
    @Override
    public boolean add(E e) {
        if (size == objects.length)
            return false;
        objects[size] = e;
        size++;
        return true;
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
    public boolean addAll(Collection<? extends E> c) {
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
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

//    //O(n)
    @Override
    public E poll() {
        if (isEmpty())
            throw new NoSuchElementException();
        E item = (E) objects[0];
        size--;
        for (int i = 0; i < size; i++) {
            objects[i] = objects[i + 1];
        }
        return item;
    }



    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
