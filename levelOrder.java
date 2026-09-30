import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class levelOrder {

    public static void levelTraversal(Node root) {

      
        if (root == null) {
            return;
        }

       
        Queue<Node> q = new LinkedList<>();

        
        q.add(root);

        while (!q.isEmpty()) {

       
            Node temp = q.remove();

            System.out.print(temp.val + " ");

   
            if (temp.left != null) {
                q.add(temp.left);
            }

 
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
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

        System.out.print("Level Order Traversal: ");

        levelTraversal(a);
    }
}
