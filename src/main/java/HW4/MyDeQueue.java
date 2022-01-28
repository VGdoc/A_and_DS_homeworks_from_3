package HW4;

public interface MyDeQueue<E> {
    boolean insertFront(E value);

    boolean insertLast(E value);

    E removeFront();

    E peekFront();

    E removeLast();

    E peekLast();

    int size();

    boolean isEmpty();

    boolean isFull();

    void displayFromStart();

    void displayFromEnd();
}
