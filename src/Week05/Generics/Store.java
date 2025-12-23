package Week05.Generics;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store<T> {

    private T[] trr;
    private ArrayList<T> items;

    public Store(Class<T> clazz) {
        trr = (T[]) Array.newInstance(clazz, 10);
        items = new ArrayList<>();
    }

    public Store() {
        trr = (T[]) Array.newInstance(Object.class, 10);
        items = new ArrayList<>();
    }

    public boolean add(T item) {
        items.add(item);
        return true;
    }

    public T remove() {
        return items.remove(items.size() - 1);
    }


}
