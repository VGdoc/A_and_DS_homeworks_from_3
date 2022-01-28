package HW4;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        linkedList.display();

        testIterator(linkedList);

    }

    private static void testHomeWork() {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();

        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }

    private static void testIterator(SimpleLinkedList<Integer> linkedList) {


        for (Integer integer : linkedList){
            System.out.println(integer);
        }

        System.out.println("*****");

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }

}
