package Week04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int num = sc.nextInt();
            int[] arr = new int[10];
            switch (num) {
                case 1:
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = new Random().nextInt(100);
                    }
                    break;


            }

            System.out.println("------Start----");
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);

//            for (int i = 0; i < arr.length; i++) {
//                bubbleSort(arr);
//                System.out.println("------Iteration " + (i + 1) + " bubbleSort ----");
//                System.out.println(Arrays.toString(arr));
//            }

            bubbleSort(arr);
            System.out.println(Arrays.toString(arr));

//            selectionSort(arr);
//            insertionSort(arr);


        }
    }

    //O(n^2)
    private static void bubbleSort(int[] arr) {
        if (arr == null)
            return;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    //O(n^2)
    private static void bubbleSortV2(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

//[67, 53, 76, 56, 21, 23, 80, 2, 23, 53]
//[53,67, 76, 56, 21, 23, 80, 2, 23, 53]
//[53,67, 76, 56, 21, 23, 80, 2, 23, 53]
//[53,67, 56,76,  21, 23, 80, 2, 23, 53]
//[53,67, 56, 21,76,  23, 80, 2, 23, 53]
//[53,67, 56, 21, 23,76,  80, 2, 23, 53]
//[53,67, 56, 21, 23,76,  80, 2, 23, 53]
//[53,67, 56, 21, 23,76,  2,80,  23, 53]
//[53,67, 56, 21, 23,76,  2,23,80, 53]
//[53,67, 56, 21, 23,76,  2,23,53,80]
//[53, 67, 56, 21, 23, 76, 2, 23, 53, 80]