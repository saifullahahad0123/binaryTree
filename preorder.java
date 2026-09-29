import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }

}

public class preorder{
    public static void dfs(Node root , ArrayList<Integer> ans){
        if(root == null ) return ;
      ans.add(root.val);
      dfs(root.left, ans);
      dfs(root.right, ans);

    }

    public static ArrayList<Integer> tri(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
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
                 
                  
                  System.out.println(tri(a));
    }
}