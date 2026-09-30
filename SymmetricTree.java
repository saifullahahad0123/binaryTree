import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SymmetricTree {

    public static boolean isSymmetric(Node root) {

        if (root == null) {
            return true;
        }

        return mirror(root.left, root.right);
    }

    public static boolean mirror(Node root1, Node root2) {

        // Both are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // One is null
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different
        if (root1.val != root2.val) {
            return false;
        }

        // Compare opposite sides
        return mirror(root1.left, root2.right)
                && mirror(root1.right, root2.left);
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3   4 4   3
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if (isSymmetric(root)) {
            System.out.println("Tree is symmetric");
        } else {
            System.out.println("Tree is not symmetric");
        }
    }
}
