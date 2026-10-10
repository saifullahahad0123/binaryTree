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

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();

            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node temp = q.remove();

                level.add(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            ans.add(level);

            leftToRight = !leftToRight;
        }

        return ans;
    }
}

public class Zig_Zag {

    public static void main(String[] args) {

    

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        Solution s = new Solution();

        ArrayList<ArrayList<Integer>> result =
                s.zigzagLevelOrder(root);

        System.out.println(result);
    }
}