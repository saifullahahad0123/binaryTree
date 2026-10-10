import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class InorderIterative {

    static void inorder(Node root) {

        Stack<Node> st = new Stack<>();

        Node curr = root;

        while (curr != null || !st.isEmpty()) {

           
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();

            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inorder(root);
    }
}