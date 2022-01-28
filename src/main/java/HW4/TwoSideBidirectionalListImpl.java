package HW4;

public class TwoSideBidirectionalListImpl<E> implements TwoSideBidirectionalList<E> {
    int size;
    BiDirectionalNode<E> first;
    BiDirectionalNode<E> last;

    @Override
    public void insertFirst(E value) {
        if (size != 0) {
            first.next = new TwoSideBidirectionalList.BiDirectionalNode<>(value, null, first);
            first = first.next;
        } else {
            first = new TwoSideBidirectionalList.BiDirectionalNode<>(value, null, first);
        }
        size++;
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (size != 0) {
            last.prev = new TwoSideBidirectionalList.BiDirectionalNode<>(value, last, null);
            last = last.prev;
        } else {
            insertFirst(value);
        }
        size++;
        if (size == 1) {
            first = last;
        }
    }

    @Override
    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }

        BiDirectionalNode<E> removedNode = first;

        first = removedNode.prev;

        if (first != null) {// тут проверяется последний ли элемент, и если да, то  last = null
            first.next = null;
        } else {
            last = null;
        }

        removedNode.prev = null;
        size--;

        return removedNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        BiDirectionalNode<E> removedNode = last;

        last = removedNode.next;

        if (last != null) { // тут проверяется последний ли элемент, и если да, то  first = null
            last.prev = null;
        } else {
            first = null;
        }

        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        BiDirectionalNode<E> current = last;

        while (current != null) {

            if (current.item.equals(value)) {
                if (current == first) {
                    first = current.prev;
                    current.prev.next = null;
                    current.prev = null;
                } else if (current == last) {
                    last = current.next;
                    current.next.prev = null;
                    current.next = null;
                } else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    current.next = null;
                    current.prev = null;
                }
                return true;
            }
            current = current.next;

        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        BiDirectionalNode<E> current = last;

        while (current != null) {

            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;

        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public void displayForward() {
        StringBuilder sb = new StringBuilder("[");
        BiDirectionalNode<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.prev != null) {
                sb.append(", ");
            }
            current = current.prev;
        }
        System.out.println(sb.append("]"));
    }

    @Override
    public void displayBackward() {

        StringBuilder sb = new StringBuilder("[");
        BiDirectionalNode<E> current = last;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        System.out.println(sb.append("]"));
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }

}
