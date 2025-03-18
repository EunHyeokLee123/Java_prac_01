package bfs;


import java.util.ArrayDeque;
import java.util.Queue;

public class binaryTreeSearch_BFS {

    static Node root;

    static void BFS(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            System.out.println("level: "+ level + ": ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data+" ");
                // 자식이 있는지
                if(cur.lt != null) queue.add(cur.lt);
                if(cur.rt != null) queue.add(cur.rt);
            }
            level++;
            System.out.println();
        }
    }


    public static void main(String[] args) {

        // 트리 구성
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);
    }
}
