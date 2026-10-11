import java.util.*;

class Node {
int val;
Node left;
Node right;


Node(int val) {
    this.val = val;
}


}

public class inorderTraversal {

public static List<Integer> inorderTraversal(Node root) {

    List<Integer> ans = new ArrayList<>();
    Stack<Node> st = new Stack<>();

    Node curr = root;

    while (curr != null || !st.isEmpty()) {

        while (curr != null) {
            st.push(curr);
            curr = curr.left;
        }

        curr = st.pop();
        ans.add(curr.val);

        curr = curr.right;
    }

    return ans;
}

public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    System.out.println(inorderTraversal(root));
}


}
