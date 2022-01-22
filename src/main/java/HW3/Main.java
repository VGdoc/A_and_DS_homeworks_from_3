package HW3;

public class Main {

    public static void main(String[] args) {

        int[] testArray1 = new int[]{1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // 11
        int[] testArray2 = new int[]{1, 2, 4, 5, 6}; // 3
        int[] testArray3 = new int[0]; // 1
        int[] testArray4 = new int[2]; // 1
        int[] testArray5 = new int[]{1, 2, 3}; // 4

        System.out.println("Найденное число - " + lostNumberFinder(testArray1) + ", а должно быть " + 11);
        System.out.println("Найденное число - " + lostNumberFinder(testArray2) + ", а должно быть " + 3);
        System.out.println("Найденное число - " + lostNumberFinder(testArray3) + ", а должно быть " + 1);
        System.out.println("Найденное число - " + lostNumberFinder(testArray4) + ", а должно быть " + 1);
        System.out.println("Найденное число - " + lostNumberFinder(testArray5) + ", а должно быть " + 4);

    }

    public static int lostNumberFinder(int[] arr){
        return 0;
    }

}
