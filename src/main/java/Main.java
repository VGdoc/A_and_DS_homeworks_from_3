import java.util.Arrays;

public class Main {

    private static double bestValue;
    private static Item[] bestSet;

    public static void main(String[] args) {

//        System.out.println("Число 2 в степени 3 равно: " + exponentiation(2, 3));
//        System.out.println("Число 2 в степени 2 равно: " + exponentiation(2, 2));
//        System.out.println("Число 2 в степени 1 равно: " + exponentiation(2, 1));
//        System.out.println("*********");
//        System.out.println("Число 2 в степени -1 равно: " + exponentiation(2, -1));
//        System.out.println("Число 2 в степени -2 равно: " + exponentiation(2, -2));
//        System.out.println("Число 2 в степени -3 равно: " + exponentiation(2, -3));
//        System.out.println("*********");
//        System.out.println("Число 2 в степени 0 равно: " + exponentiation(1, 0));

        Item[] items = new Item[10];

        items[0] = new Item("Item_01", 2, 1);
        items[1] = new Item("Item_02", 3, 2);
        items[2] = new Item("Item_03", 4, 3);
        items[3] = new Item("Item_04", 5, 4);
        items[4] = new Item("Item_05", 6, 5);
        items[5] = new Item("Item_06", 7, 1);
        items[6] = new Item("Item_07", 8, 2);
        items[7] = new Item("Item_08", 9, 3);
        items[8] = new Item("Item_09", 10, 4);
        items[9] = new Item("Item_10", 15, 5);

        bagTask(items, 5, items.length);
        for (Item a : bestSet) {
            System.out.println(a);
        }
    }

    private static void bagTask(Item[] items, double weightLimit, int length) {

        if (totalWeight(items, length) > weightLimit) {
            if (length == 1) {
                return;
            }
            for (int i = 0; i < length; i++) {
                bagTask(items, weightLimit, length - 1);
                rotate(items, length);
            }

        } else {
            double totalValue = totalValue(items, length);
            if (totalValue > bestValue) {
                bestValue = totalValue;
                bestSet = saveArray(items, length);
            }
        }
    }

    private static Item[] saveArray(Item[] items, int length) {
        Item[] result = new Item[length];
        for (int i = 0; i < length; i++) {
            result[i] = items[i];
        }
        return result;
    }

    private static void rotate(Item[] items, int length) {
        int start = items.length - length;

        Item temp = items[start];
        for (int i = start + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[items.length - 1] = temp;
    }

    private static double totalValue(Item[] items, int length) {
        double result = 0;
        for (int i = 0; i < length; i++) {
            result += items[i].getValue();
        }
        return result;
    }

    private static double totalWeight(Item[] items, int length) {
        double result = 0;
        for (int i = 0; i < length; i++) {
            result += items[i].getWeight();
        }
        return result;
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
