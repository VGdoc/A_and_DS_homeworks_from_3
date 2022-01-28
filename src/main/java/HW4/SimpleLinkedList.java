package HW4;

import java.util.Iterator;

public class SimpleLinkedList<E> implements LinkedList<E>, Iterable<E> {

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return null;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }
        if ((current == null)) {
            return false;
        }
        if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {

        Node<E> current = first;

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
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<T> implements Iterator<E>{
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            if (current != null){
                return true;
            }
            reset();
            return false;
        }

        @Override
        public E next() {
            Node<E> temp = current;
            current = current.next;
            return temp.item;
        }

        public void reset(){
            current = first;
        }
    }

}
