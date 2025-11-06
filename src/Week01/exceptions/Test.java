package Week01.exceptions;

public class Test {


    public static void main(String[] args) {

        try {
            arithmetic();
        } catch (ArithmeticException ae) {
            System.out.println(" Arithmetic Exception");
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        try {
            indexOut();
        } catch (ArithmeticException ae) {
            System.out.println(" Arithmetic Exception");
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
            
        } finally {
            System.out.println("finally");
        }
        System.out.println("finished");
    }

    public static void arithmetic() throws ArithmeticException {
        Integer x[] = {1, 2, 3, 0, 8, null, 4};
        for (int i = 0; i <= x.length; i++) {
            if (x[i] == 0)
                throw new ArithmeticException("Arithmetic--Exception");

            int y = 10 / x[i];
//            System.out.println("y = " + y);
        }
    }

    public static void indexOut() throws ArrayIndexOutOfBoundsException {
        Integer x[] = {1, 2, 3, 1, 8, 12, 4};
        for (int i = 0; i <= x.length; i++) {

            if (i == x.length)
                throw new ArrayIndexOutOfBoundsException("Array-Index-Out-Of-Bounds-Exception");
            int y = 10 / x[i];
//            System.out.println("y = " + y);
        }
    }

    public static void a() throws Exception {
        b();
    }

    public static void b() throws Exception {
        c();
    }

    public static void c() {
        try {
            f();
        } catch (Exception e) {

        }
        throw new ArithmeticException();
    }

    public static void f() throws Exception {
        throw new Exception();
    }
}


