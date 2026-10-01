import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {

        // Final answer
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return ans;
        }

        // Queue for BFS
        Queue<Node> q = new LinkedList<>();

        // Add root
        q.add(root);

        while (!q.isEmpty()) {

            // Number of nodes in current level
            int size = q.size();

            // Store current level
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                // Remove node from queue
                Node temp = q.remove();

                // Add value to current level
                level.add(temp.data);

                // Add left child
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add right child
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            // Add current level to answer
            ans.add(level);
        }

        return ans;
    }
}

public class level {

    public static void main(String[] args) {

        /*
                    10
                   /  \
                 20    30
                / \    /
               40 50  60
        */

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);

        Solution s = new Solution();

        ArrayList<ArrayList<Integer>> result = s.levelOrder(root);

        System.out.println(result);
    }
}