import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class AllPaths {

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {

    
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            ArrayList<Integer> arr = new ArrayList<>();

    
        dfs(root, arr, ans);

        return ans;
    }

    private static void dfs(
            Node root,
            ArrayList<Integer> arr,
            ArrayList<ArrayList<Integer>> ans) {


        if (root == null) {
            return;
        }


        arr.add(root.data);


        if (root.left == null && root.right == null) {


            ArrayList<Integer> list = new ArrayList<>(arr);

  ans.add(list);

            arr.remove(arr.size() - 1);

            return;
        }

      dfs(root.left, arr, ans);

        
        dfs(root.right, arr, ans);

                arr.remove(arr.size() - 1);
    }

    public static void main(String[] args) {

      

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);

        ArrayList<ArrayList<Integer>> result = Paths(root);

        System.out.println(result);
    }
}