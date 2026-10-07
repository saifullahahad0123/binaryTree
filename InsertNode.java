import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class InsertNode {

    static Node insert(Node root, int value) {

    
        if (root == null) {
            return new Node(value);
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            Node current = q.remove();

          
            if (current.left == null) {

                current.left = new Node(value);
                return root;

            } else {
                q.add(current.left);
            }

            if (current.right == null) {

                current.right = new Node(value);
                return root;

            } else {
                q.add(current.right);
            }
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

        System.out.println("Before insertion:");

        levelOrder(root);


        root = insert(root, 6);

        System.out.println("\nAfter insertion:");

        levelOrder(root);
    }
}
