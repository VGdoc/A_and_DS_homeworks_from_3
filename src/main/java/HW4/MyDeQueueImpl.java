package HW4;

public class MyDeQueueImpl<E> implements MyDeQueue<E> {

    private final TwoSideBidirectionalListImpl<E> data;

    public MyDeQueueImpl() {
        this.data = new TwoSideBidirectionalListImpl<>();
    }

    @Override
    public boolean insertFront(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeFront() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public E removeLast() {
        return data.removeLast();
    }

    @Override
    public E peekLast() {
        return data.getLast();
    }

    @Override
    public int size() {
        return data.size;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void displayFromStart() {
        data.displayForward();
    }

    @Override
    public void displayFromEnd() {
        data.displayBackward();
    }
}
