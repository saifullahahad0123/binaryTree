import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class Solution {

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {

      
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

   
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();

   
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node node = q.remove();

                level.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }

        return ans;
    }
}

public class levelArrList {

    public static void main(String[] args) {


        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

    
        Solution obj = new Solution();

      
        ArrayList<ArrayList<Integer>> result =
                obj.levelOrder(root);

        System.out.println(result);
    }
}