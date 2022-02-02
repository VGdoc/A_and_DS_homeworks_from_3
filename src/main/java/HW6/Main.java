package HW6;

import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {

        TreeImpl<Integer>[] trees = new TreeImpl[20];

        for (int i = 0; i < trees.length; i++) {
            trees[i] = createRandomTree();
        }

        for (int i = 0; i < trees.length; i++) {
            System.out.println(Tree.isBalanced(trees[i].getRoot()));
        }




    }

    private static TreeImpl<Integer> createRandomTree() {
        TreeImpl<Integer> tree = new TreeImpl<>();
        for (int i = 0; i < 15; i++) {
            tree.add(random.nextInt(50)-25);
        }
        return tree;
    }

}
