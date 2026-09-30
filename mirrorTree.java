import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class mirrorTree {

    public static void mirror(Node root) {

        
        if (root == null) {
            return;
        }

    
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    
        mirror(root.left);

    
        mirror(root.right);
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

        // Creating nodes
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

        System.out.print("Before mirror: ");
        preorder(a);

       
        mirror(a);

        System.out.print("\nAfter mirror:  ");
        preorder(a);
    }
}