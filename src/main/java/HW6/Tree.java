package HW6;

public interface Tree<E extends Comparable<? super E>> {

    Node<E> getRoot();

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    void display();

    void traverse(TraversMode mode);

}