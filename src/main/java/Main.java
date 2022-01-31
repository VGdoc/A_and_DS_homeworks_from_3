public class Main {

    public static void main(String[] args) {

        System.out.println("Число 2 в степени 3 равно: " + exponentiation(2, 3));
        System.out.println("Число 2 в степени 2 равно: " + exponentiation(2, 2));
        System.out.println("Число 2 в степени 1 равно: " + exponentiation(2, 1));
        System.out.println("*********");
        System.out.println("Число 2 в степени -1 равно: " + exponentiation(2, -1));
        System.out.println("Число 2 в степени -2 равно: " + exponentiation(2, -2));
        System.out.println("Число 2 в степени -3 равно: " + exponentiation(2, -3));
        System.out.println("*********");
        System.out.println("Число 2 в степени 0 равно: " + exponentiation(1, 0));


    }

    /**
     * метод вовзводит число в степень с помощью рекурсии
     *
     * @param number        число для возведения в степень
     * @param exponentLevel степень
     * @return результат
     */
    private static double exponentiation(double number, int exponentLevel) {

        if (exponentLevel < 0) {
            number = 1 / number;
            exponentLevel = Math.abs(exponentLevel);
        }

        if (exponentLevel == 1) {
            return number;
        } else {
            return number * exponentiation(number, exponentLevel - 1);
        }

    }

}
