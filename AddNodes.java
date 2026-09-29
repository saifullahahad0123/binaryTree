class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }

}

public class AddNodes{

    public static int Number(Node a){
        if (a == null) return 0 ;
        return 1 + Number(a.left) + Number(a.right); 

    }

    public static int Mul(Node a){
        if (a == null) return 1 ;
        return a.val * Number(a.left) * Number(a.right); 

    }

    public static int Add(Node root){
        if(root == null) return 0;
        return root.val + Add(root.left) + Add(root.right); 

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
                 
                  
                  System.out.println(Number(a));
                  System.out.println(Add(a));
  System.out.println(Mul(a));
    }
}