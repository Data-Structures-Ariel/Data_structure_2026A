package Week05.Generics;

import java.util.ArrayList;

public class Car<T> {

    ArrayList arrayList;

    T item;
    public Car(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
//    public T getByIndex(int index){
//        return arrayList.get(index);
//    }


    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Car{" +
                "arrayList=" + arrayList +
                ", item=" + item +
                '}';
    }
}
