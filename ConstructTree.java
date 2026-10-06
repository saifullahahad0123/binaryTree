import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class ConstructTree {

    static int postIndex;

    static Node buildTree(int[] inorder, int[] postorder,
                          int start, int end) {

        // No elements
        if (start > end) {
            return null;
        }

        // Last element of postorder is root
        int rootValue = postorder[postIndex];

        postIndex--;

        Node root = new Node(rootValue);

        // Find root in inorder
        int index = start;

        while (inorder[index] != rootValue) {
            index++;
        }

        // IMPORTANT:
        // Build RIGHT first
        root.right = buildTree(
            inorder,
            postorder,
            index + 1,
            end
        );

        // Then LEFT
        root.left = buildTree(
            inorder,
            postorder,
            start,
            index - 1
        );

        return root;
    }

    static void printPreorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        postIndex = postorder.length - 1;

        Node root = buildTree(
            inorder,
            postorder,
            0,
            inorder.length - 1
        );

        System.out.println("Preorder:");

        printPreorder(root);
    }
}