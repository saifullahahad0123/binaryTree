import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class TopView {

    static void topView(Node root) {

        if (root == null) {
            return;
        }

        // horizontal distance -> node value
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        // root has horizontal distance 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair current = q.remove();

            Node node = current.node;
            int hd = current.hd;

            // Store only the first node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            // Left child -> hd - 1
            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            // Right child -> hd + 1
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // Print top view
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    static class Pair {

        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.right.left = new Node(7);

        topView(root);
    }
}