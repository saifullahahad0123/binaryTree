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

            // Step 1: Go as far left as possible
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // Step 2: Pop and visit the node
            curr = st.pop();

            System.out.print(curr.val + " ");

            // Step 3: Move to the right subtree
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