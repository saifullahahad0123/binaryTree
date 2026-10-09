class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class MaxDepth {

    static int maxDepth(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Find the depth of the left subtree
        int leftDepth = maxDepth(root.left);

        // Find the depth of the right subtree
        int rightDepth = maxDepth(root.right);

        // Return the greater depth + current node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.left.left = new Node(6);

        System.out.println(maxDepth(root));
    }
}