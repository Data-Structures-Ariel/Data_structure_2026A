package Week05;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        int a = 1, b = 3;
        boolean aBool = true, bBool = false;
        unCompare(a, b);
        unCompare(aBool, bBool);

        Integer i = 3;




//        ArrayList<? extends Integer> ll = new ArrayList<>();


    }

//    private static void unCompare(boolean aBool, boolean bBool) {
//        System.out.println("a != b " + (aBool != bBool));
//    }
//
//    private static void unCompare(int a, int b) {
//        System.out.println("a != b " + (a != b));
//    }

    private static void unCompare(Object a, Object b) {
        System.out.println("a != b " + (!a.equals(b)));
    }

}
