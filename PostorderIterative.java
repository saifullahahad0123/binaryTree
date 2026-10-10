import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class PostorderIterative {

    static void postorder(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {

            Node curr = st1.pop();

            st2.push(curr);

            if (curr.left != null) {
                st1.push(curr.left);
            }

            if (curr.right != null) {
                st1.push(curr.right);
            }
        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().val + " ");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        postorder(root);
    }
}