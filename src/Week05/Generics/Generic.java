package Week05.Generics;

public class Generic {

    static <T> void IsEq(T n1, T n2) {
        System.out.println("n1 = " + n1 + " , n2 = " + n2);
    }

    static <T> T IsgEN(T n1, T n2) {
        return n1;
    }

    public static void main(String[] args) {
        IsEq(2, 2);
        IsEq("bob", "bob");
        IsEq(true, true);


    }
}

class Overloading {

    static boolean IsEq(int n1, int n2) {
        return n1 == n2;
    }

    static boolean IsEq(String n1, String n2) {
        return n1 == n2;
    }

    static boolean IsEq(boolean n1, boolean n2) {
        return n1 == n2;
    }


    public static void main(String[] args) {
        System.out.println(IsEq(2, 2));
        System.out.println(IsEq("bob", "bob"));
        System.out.println(IsEq(true, true));

    }

}

class GenericsFewType {
    static <T, S> void IsEq(T n1, S n2) {
        System.out.println("n1 = " + n1 + " , n2 = " + n2);
    }

    public static void main(String[] args) {
        //IS CALLED AS: static void IsEq<int,String>(int n1, string n2)
        IsEq(2, "bob");

        //IS CALLED AS: static void IsEq<String,boolean>(string n1, bool n2)
        IsEq("bob", false);

    }
}
