package HW3;

public class Main {

    public static void main(String[] args) {

        int[] testArray1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // 11
        int[] testArray2 = new int[]{1, 2, 4, 5, 6}; // 3
        int[] testArray3 = new int[0]; // 1
        int[] testArray4 = new int[]{2}; // 1
        int[] testArray44 = new int[]{2, 3}; // 1
        int[] testArray5 = new int[]{1, 2, 3}; // 4
        int[] testArray6 = new int[]{1}; // 2

        System.out.println("Найденное число - " + lostNumberFinder(testArray1) + ", а должно быть " + 11);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray2) + ", а должно быть " + 3);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray3) + ", а должно быть " + 1);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray4) + ", а должно быть " + 1);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray44) + ", а должно быть " + 1);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray5) + ", а должно быть " + 4);
        System.out.println();
        System.out.println("Найденное число - " + lostNumberFinder(testArray6) + ", а должно быть " + 2);

    }

    public static int lostNumberFinder(int[] arr) {
        int i = 0;

        if (arr.length == 0 ||
                arr.length == 1 && arr[0] != 1) {
            System.out.println("Кол-во итераций: " + i);
            return 1;
        }

        int start = 0;
        int end = arr.length - 1;
        int base;


        while (true) {
            i++;

            base = (end + start) / 2;


            if (start > end) {
                System.out.println("Кол-во итераций: " + i);
                return start + 1;
            } else if (start == end) {
                System.out.println("Кол-во итераций: " + i);
                return start + 2;
            }


            if (!isCorrectNumberOnPosition(arr, base)) {
                if (base - 1 < 0){
                    System.out.println("Кол-во итераций: " + i);
                    return 1;
                }
                if (arr[base] - arr[base - 1] != 1) {
                    System.out.println("Кол-во итераций: " + i);
                    return arr[base] - 1;
                }
                end = base - 2;
            } else {
                if (arr[base + 1] - arr[base] != 1) {
                    System.out.println("Кол-во итераций: " + i);
                    return arr[base] + 1;
                }
                start = base + 2;
            }


        }
    }

    public static boolean isCorrectNumberOnPosition(int[] arr, int index) {
        return arr[index] == index + 1;
    }

}
