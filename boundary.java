import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class boundary {

    static ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        if (root.left != null || root.right != null) {
            ans.add(root.data);
        } else {
            ans.add(root.data);
            return ans;
        }
        leftBoundary(root.left, ans);

  
        leafNodes(root, ans);

        rightBoundary(root.right, ans);

        return ans;
    }

    // Left boundary: Top to bottom
    static void leftBoundary(Node root, ArrayList<Integer> ans) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.data);

        if (root.left != null) {
            leftBoundary(root.left, ans);
        } else {
            leftBoundary(root.right, ans);
        }
    }

    static void leafNodes(Node root, ArrayList<Integer> ans) {

        if (root == null) {
            return;
        }

 
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    // Right boundary: Bottom to top
    static void rightBoundary(Node root, ArrayList<Integer> ans) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, ans);
        } else {
            rightBoundary(root.left, ans);
        }

     
        ans.add(root.data);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        System.out.println(boundaryTraversal(root));
    }
}