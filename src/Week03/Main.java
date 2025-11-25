package Week03;

public class Main {
    public static void main(String[] args) {
        // 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5
        int arr[] = {20, 0, 5, 7, 11, 0, 7, 11, 1, 4, 0, 4, 5, 20};

        int maxIndex = 0; // O(1) ~ 1
        int max = 0; // O(1) ~ 1
        int countMax = 0; // O(1) ~ 1
        for (int i = 0 /*O(1) ~ 1*/; i < arr.length;/*O(n) ~ n*/ i++ /*O(n) ~ n*/) {

            // n = len(arr)
            for (int j = 0 /*O(1) ~ 1*/; j < arr.length /*O(n) ~ n*/; j++ /*O(n) ~ n*/) {
                if (arr[i] == arr[j]) // O(1) ~ 1
                    countMax++;// O(1) ~ 1
            }
            // 1 + n + n + 2n = 4n+1

            if (countMax > max) {// O(1) ~ 1
                max = countMax;// O(1) ~ 1
                maxIndex = i;// O(1) ~ 1
            }
            countMax = 0;// O(1) ~ 1
        }

        System.out.println(arr[maxIndex]);// O(1) ~ 1
        System.out.println(max);// O(1) ~ 1

        // 1 + n + n + n(4n+1) + 4n = 1 + 2n + 4n^2+n+4n =  4n^2 + 7n + 3
        // 4n^2 + 7n + 3 = an^2+bn+c ~ O(n^2)


        for (int i = 0 /*O(1) ~ 1*/; i < arr.length;/*O(n) ~ n*/ i++ /*O(n) ~ n*/) {

            countMax = findNum(arr, i);

            if (countMax > max) {// O(1) ~ 1
                max = countMax;// O(1) ~ 1
                maxIndex = i;// O(1) ~ 1
            }
            countMax = 0;// O(1) ~ 1
        }
        // 1 + n + n + n(4n+1)

        System.out.println(arr[maxIndex]);// O(1) ~ 1
        System.out.println(max);// O(1) ~ 1


        int[] counter = new int[21]; // O(1) ~ 1
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;
        } // 3n+1
        int maxInx = 0; // O(1) ~ 1
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > counter[maxInx])
                maxInx = i;
        }// O(1) ~ 85

        // 3n+88
    }

    // O(n) ~ 4n+3
    private static int findNum(int[] arr, int i) {
        int countMax = 0; // O(1) ~ 1
        // n = len(arr)
        for (int j = 0 /*O(1) ~ 1*/; j < arr.length /*O(n) ~ n*/; j++ /*O(n) ~ n*/) {
            if (arr[i] == arr[j]) // O(1) ~ 1
                countMax++;// O(1) ~ 1
        }
        return countMax;
        // 1 + n + n + 2n + 1 + 1 = 4n+3
    }


}
