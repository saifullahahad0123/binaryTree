class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class mindepth {

    static int minDepth(Node root) {

        if (root == null) {
            return 0;
        }

      
        int left = minDepth(root.left);

        int right = minDepth(root.right);

        if (root.left == null) {
            return 1 + right;
        }

        if (root.right == null) {
            return 1 + left;
        }

        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.right.right = new Node(5);

        root.left.left.left = new Node(6);

        System.out.println(minDepth(root));
    }
}