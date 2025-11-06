public class Main {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        for (int i = 0; i <= arr.length; i++)
            arr[i] = i;
        try {
            for (int i = 0; i <= arr.length; i++) arr[i] = i;
        } catch
        (ArrayIndexOutOfBoundsException e) {
            System.out.println("array index out of bounds");
            System.out.println(e);

        }
        getValue(4);
    }

    public static double getValue(int num) throws ArithmeticException {
        if (num < 0) throw new ArithmeticException();
        else
            return Math.sqrt(num);
    }

}