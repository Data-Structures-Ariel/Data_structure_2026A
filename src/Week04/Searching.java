package Week04;

import java.util.Arrays;
import java.util.Random;

public class Searching {

    public static void main(String[] args) {


        int[] arr = new int[1000000000];
        System.out.println("---------------------------------------------");
        System.out.println("Start");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(0, 10000000);
        }
        System.out.println("End");
        long endTime = System.currentTimeMillis();
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");

//        System.out.println("---------------------------------------------");
//        startTime = System.currentTimeMillis();
//        System.out.println("Start");
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random().nextInt(0, 500);
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.println("End");
//        endTime = System.currentTimeMillis();
//        System.out.println("Time -> " + (endTime - startTime));
//        System.out.println("---------------------------------------------");


        System.out.println("--------------------contains-------------------------");
        startTime = System.currentTimeMillis();
        boolean bool = contains(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");

        System.out.println("-----------------------containsV2----------------------");
        startTime = System.currentTimeMillis();
        bool = containsV2(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");


        System.out.println("-----------------------containsV3----------------------");
        startTime = System.currentTimeMillis();
        bool = containsV3(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");


        System.out.println("----------------------containsV4-----------------------");
        startTime = System.currentTimeMillis();
        bool = containsV4(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");

        Arrays.sort(arr);

        System.out.println("----------------------BinarySearchIter-----------------------");
        startTime = System.currentTimeMillis();
        bool = BinarySearchIter(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");

        System.out.println("----------------------BinarySearchRec-----------------------");
        startTime = System.currentTimeMillis();
        bool = BinarySearchRec(arr, 105);
        endTime = System.currentTimeMillis();
        System.out.println(bool);
        System.out.println("Time -> " + (endTime - startTime));
        System.out.println("---------------------------------------------");

    }

    private static boolean BinarySearchRec(int[] arr, int left, int right, int num) {

        if (arr == null)
            return false;

        int mid = (left + right) / 2;

        if (arr[mid] == num)
            return true;

        if (arr[mid] < num)
            return BinarySearchRec(arr, mid + 1, right, num);
        else
            return BinarySearchRec(arr, left, mid - 1, num);


    }

    public static boolean BinarySearchRec(int[] arr, int num) {
        return BinarySearchRec(arr, 0, arr.length - 1, num);
    }

    public static boolean BinarySearchR(int[] arr, int num) {

        if (arr == null)
            return false;

        int left = 0, right = arr.length - 1;
        int mid = (left + right) / 2;

        if (arr[mid] == num)
            return true;

        if (arr[mid] < num)
            return BinarySearchRec(Arrays.copyOfRange(arr, mid + 1, right+1), num);
        else
            return BinarySearchRec(Arrays.copyOfRange(arr, left, mid), num);


    }

    private static boolean BinarySearchIter(int[] arr, int num) {
        if (arr == null)
            return false;

        int left = 0, right = arr.length - 1;

        while (left != right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num)
                return true;

            if (arr[mid] < num)
                left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }


    private static boolean contains(int[] arr, int num) {
        if (arr == null)
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                System.out.println("Index -> " + i);
                return true;
            }
        }
        return true;
    }

    private static boolean containsV2(int[] arr, int num) {
        if (arr == null)
            return false;
        int start = 0, end = arr.length - 1;
        boolean bool = false;
        while (start != end) {

            if (arr[start] == num) {
                System.out.println("Index -> " + start);
                return true;
            }
            if (arr[end] == num) {
                System.out.println("Index -> " + end);
                return true;
            }

            start += (bool) ? 1 : 0;
            end += (bool) ? 0 : -1;
            bool = !bool;
        }
        return true;
    }

    private static boolean containsV3(int[] arr, int num) {
        if (arr == null)
            return false;
        int start = 0, end = arr.length - 1;

        while (start != end) {

            if (arr[start] == num) {
                System.out.println("Index -> " + start);
                return true;
            }
            if (arr[end] == num) {
                System.out.println("Index -> " + end);
                return true;
            }

            start++;
            end--;

        }
        return true;
    }

    private static boolean containsV4(int[] arr, int num) {
        if (arr == null)
            return false;
        int start = 0, end = arr.length - 1;
        int midLeft = arr.length / 2, midRight = arr.length / 2;

        while (start != midLeft && end != midRight) {

            if (arr[start] == num) {
                System.out.println("Index -> " + start);
                return true;
            }
            if (arr[midLeft] == num) {
                System.out.println("Index -> " + midLeft);
                return true;
            }
            if (arr[midRight] == num) {
                System.out.println("Index -> " + midRight);
                return true;
            }
            if (arr[end] == num) {
                System.out.println("Index -> " + end);
                return true;
            }

            start++;
            midLeft--;
            midRight--;
            end--;

        }
        return true;
    }
}
