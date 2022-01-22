package HW3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        final int ARRAY_ELEMENT_QUANTITY = 35000000;
        final int LOST_NUMBER = 36; // нужно указывать число, которое ожидается получить

        //тесты метода lostNumberFinder()
        //System.out.println("Массив " + Arrays.toString(createArray(ARRAY_ELEMENT_QUANTITY, LOST_NUMBER)));
        System.out.println("Мы нашли число " + lostNumberFinder(createArray(ARRAY_ELEMENT_QUANTITY, LOST_NUMBER)) + ", а должно быть " + LOST_NUMBER);



    }

    /**
     * Метод нахидит пропущенное число по заданию, за основу взят бинарный поиск
     * @param arr целочисленный массив
     * @return найденное число
     */
    public static int lostNumberFinder(int[] arr) {
        int i = 0;

        // сразу проверяем пустой массив и массив из одного неправильного элемента
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

            //обрабатываем случаи когда start перепрыгнул end, и когда они равны
            if (start > end) {
                System.out.println("Кол-во итераций: " + i);
                return start + 1;
            } else if (start == end) {
                System.out.println("Кол-во итераций: " + i);
                return start + 2;
            }


            if (!isCorrectNumberOnPosition(arr, base)) {
                //если номер не на своём месте - сравниваем с предыдущим (проверяем на границы)
                // если они идут подряд - переносим end на 2 позиции назад
                //иначе возвращаем ответ
                if (base - 1 < 0) {
                    System.out.println("Кол-во итераций: " + i);
                    return 1;
                }
                if (arr[base] - arr[base - 1] != 1) {
                    System.out.println("Кол-во итераций: " + i);
                    return arr[base] - 1;
                }
                end = base - 2;
            } else {
                //если номер на своём месте - сравниваем со следующим (НЕ проверяем на границы, т.к. на данном этапе уверены что start и end не равны)
                //если они идут подряд - переносим start на 2 позиции вперед
                //иначе возвращаем ответ
                if (arr[base + 1] - arr[base] != 1) {
                    System.out.println("Кол-во итераций: " + i);
                    return arr[base] + 1;
                }
                start = base + 2;
            }


        }
    }


    /**
     * Метод создаёт массив заданной длины и пропускает в нём заданное число
     * @param elementQuantity кол-во элементов массива
     * @param lostNumber число которое нужно потерять
     * @return готовый массив
     */
    public static int[] createArray(int elementQuantity, int lostNumber) {

        int[] arr = new int[elementQuantity];
        boolean isLostNumberUsed = false;
        for (int i = 0; i < elementQuantity; i++) {

            if (i + 1 == lostNumber) {
                isLostNumberUsed = true;
            }

            if (!isLostNumberUsed) {
                arr[i] = i + 1;
            } else {
                arr[i] = i + 2;
            }
        }

         return arr;
    }

    /**
     * метод определяет находится ли элемент на своём месте основываясь на индексе
     * @param arr массив
     * @param index инендекс для проверки
     * @return true если элемент на месте, иначе false
     */
    public static boolean isCorrectNumberOnPosition(int[] arr, int index) {
        return arr[index] == index + 1;
    }

}
