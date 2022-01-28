package HW4;

public interface TwoSideBidirectionalList<E> {

    void insertFirst(E value);

    void insertLast(E value);

    E removeFirst();

    E removeLast();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void displayForward();

    void displayBackward();

    E getFirst();

    E getLast();

    E peekFirst();

    E peekLast();

    class BiDirectionalNode<E> {
        E item;
        BiDirectionalNode<E> next;
        BiDirectionalNode<E> prev;

        public BiDirectionalNode(E item, BiDirectionalNode<E> next, BiDirectionalNode<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
