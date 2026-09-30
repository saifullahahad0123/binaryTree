class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }

}

public class targetSum{

public static boolean target(Node root , int targetVal) {
    if( root == null) return false;
    if(root.left == null && root.right == null){
        if(targetVal == root.val ) return true;
        else return false;

    }
  return target(root.left, targetVal - root.val) || target(root.right , targetVal - root.val);
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

                  System.out.println(target(a, 100));


    }
}

