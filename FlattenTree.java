class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class FlattenTree {

    public static void flatten(Node root) {

        if (root == null) {
            return;
        }

        flatten(root.left);

        flatten(root.right);

        Node temp = root.right;

        root.right = root.left;

        root.left = null;
        Node current = root.right;

        while (current != null && current.right != null) {
            current = current.right;
        }

        if (current != null) {
            current.right = temp;
        } else {
            root.right = temp;
        }
    }

    public static void print(Node root) {

        while (root != null) {

            System.out.print(root.val + " ");

            if (root.left != null) {
                System.out.println("ERROR: Left child exists");
                return;
            }

            root = root.right;
        }
    }

    public static void main(String[] args) {


        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);

        flatten(root);

        System.out.print("Flattened tree: ");

        print(root);
    }
}