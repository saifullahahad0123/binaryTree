class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class PerfectTree {

    // Find height of tree
    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        return Math.max(
                height(root.left),
                height(root.right)
        ) + 1;
    }

    // Check whether tree is perfect
    public static boolean isPerfect(Node root) {

        if (root == null) {
            return true;
        }

        int h = height(root);

        return checkPerfect(root, h, 1);
    }

    public static boolean checkPerfect(Node root, int height, int level) {

        // Empty node
        if (root == null) {
            return true;
        }

        // Leaf node
        if (root.left == null && root.right == null) {

            // Leaf must be at the last level
            return height == level;
        }

        // One child means not perfect
        if (root.left == null || root.right == null) {
            return false;
        }

        // Check both subtrees
        return checkPerfect(root.left, height, level + 1)
                && checkPerfect(root.right, height, level + 1);
    }

    public static void main(String[] args) {


        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        if (isPerfect(root)) {
            System.out.println("Tree is perfect");
        } else {
            System.out.println("Tree is not perfect");
        }
    }
}
