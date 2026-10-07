import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class DeleteNode {

    static Node delete(Node root, int value) {

        // Empty tree
        if (root == null) {
            return null;
        }

        // If root itself is the only node
        if (root.left == null && root.right == null) {

            if (root.val == value) {
                return null;
            }

            return root;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        Node target = null;
        Node deepest = null;
        Node parentOfDeepest = null;

        while (!q.isEmpty()) {

            Node current = q.remove();

            // Find target node
            if (current.val == value) {
                target = current;
            }

            // Find deepest node and its parent
            if (current.left != null) {

                parentOfDeepest = current;
                deepest = current.left;

                q.add(current.left);
            }

            if (current.right != null) {

                parentOfDeepest = current;
                deepest = current.right;

                q.add(current.right);
            }
        }

        // Target not found
        if (target == null) {
            return root;
        }

        // Replace target value
        target.val = deepest.val;

        // Delete deepest node
        if (parentOfDeepest.right == deepest) {

            parentOfDeepest.right = null;

        } else {

            parentOfDeepest.left = null;
        }

        return root;
    }

    static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            Node current = q.remove();

            System.out.print(current.val + " ");

            if (current.left != null) {
                q.add(current.left);
            }

            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Before deletion:");

        levelOrder(root);

        root = delete(root, 5);

        System.out.println("\nAfter deletion:");

        levelOrder(root);
    }
}
