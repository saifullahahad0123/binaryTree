import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    // Constructor
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class identicalTree {
    public static boolean identical(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return identical(root1.left, root2.left)
                && identical(root1.right, root2.right);
    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

      

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(60);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;


        

        Node x = new Node(10);
        Node y = new Node(20);
        Node z = new Node(30);
        Node p = new Node(40);
        Node q = new Node(50);
        Node r = new Node(60);

        x.left = y;
        x.right = z;

        y.left = p;
        y.right = q;

        z.left = r;


        System.out.print("Tree 1: ");
        preorder(a);

        System.out.print("\nTree 2: ");
        preorder(x);

        boolean result = identical(a, x);

        System.out.println();

        if (result) {
            System.out.println("Both trees are identical");
        } else {
            System.out.println("Both trees are not identical");
        }
    }
}