import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class LCA {

    public static boolean findPath(
            Node root,
            int target,
            ArrayList<Node> path) {

        if (root == null) {
            return false;
        }

        path.add(root);

        // Target found
        if (root.val == target) {
            return true;
        }

        // Search left
        if (findPath(root.left, target, path)) {
            return true;
        }

        // Search right
        if (findPath(root.right, target, path)) {
            return true;
        }

        // Backtrack
        path.remove(path.size() - 1);

        return false;
    }

    public static Node findLCA(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // If either node doesn't exist
        if (!findPath(root, n1, path1)
                || !findPath(root, n2, path2)) {
            return null;
        }

        int i = 0;

        // Find last common node
        while (i < path1.size()
                && i < path2.size()
                && path1.get(i) == path2.get(i)) {

            i++;
        }

        return path1.get(i - 1);
    }

    public static void main(String[] args) {

 

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        int n1 = 40;
        int n2 = 50;

        Node result = findLCA(root, n1, n2);

        if (result != null) {
            System.out.println("LCA = " + result.val);
        } else {
            System.out.println("LCA not found");
        }
    }
}