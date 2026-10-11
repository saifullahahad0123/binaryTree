import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class inpre {

    public static Node buildTree(int inorder[], int preorder[]) {

        int n = inorder.length;

        return build(0, n - 1, 0, n - 1, inorder, preorder);
    }

    public static Node build(
            int preLo,
            int preHi,
            int inLo,
            int inHi,
            int inorder[],
            int preorder[]) {
        if (preLo > preHi || inLo > inHi) {
            return null;
        }

     
        int val = preorder[preLo];

        Node root = new Node(val);

    
        int r = -1;

        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }
        int cnt = r - inLo;

       
        root.left = build(
                preLo + 1,
                preLo + cnt,
                inLo,
                r - 1,
                inorder,
                preorder
        );

     
        root.right = build(
                preLo + cnt + 1,
                preHi,
                r + 1,
                inHi,
                inorder,
                preorder
        );

        return root;
    }

    public static void inorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        System.out.print(root.data + " ");

        inorderTraversal(root.right);
    }

    public static void preorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorderTraversal(root.left);

        preorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        postorderTraversal(root.left);

        postorderTraversal(root.right);

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        int inorder[] = {4, 2, 5, 1, 6, 3, 7};

        int preorder[] = {1, 2, 4, 5, 3, 6, 7};

        Node root = buildTree(inorder, preorder);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);

        System.out.println();

        System.out.print("Preorder Traversal: ");
        preorderTraversal(root);

        System.out.println();

        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);

        System.out.println();
    }
}