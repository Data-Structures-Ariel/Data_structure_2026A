package Week02;

public class Main {

    public static void main(String[] args) {

        String str = "ABCIEFG"; // n = 7
        int i = 0; // 1

        // 3n
        while (str.length() != i /* 1*/ && str.charAt(i) != 'D'/* 1*/) {
            i++;/* 1*/
        }

        if (i == str.length()/* 1*/) {
            System.out.println("");/* 1*/
        } else {
            System.out.println("");/* 1*/
        }
        //n=10 -> 33
        //n=100 -> 303
        // 3n+3

        str = str + "D"; // 1

        //"ABCIEFGD";
        while (str.charAt(i) != 'D'/* 1*/) {
            i++;/* 1*/
        }

        if (i == str.length() - 1/* 1*/) {
            System.out.println("");/* 1*/
        } else {
            System.out.println("");/* 1*/
        }
        str = str.substring(0, str.length() - 1); // 1
        //"ABCIEFG";
        // 2n+5
        //n=10 ->25
        //n=100 -> 205
    }
}
