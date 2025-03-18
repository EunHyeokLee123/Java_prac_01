package dfs;



public class 이진트리순회_DFS {

    static Node root;

    /*
            트리 모양:
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

    // 전위 순회(pre-order) 루트 -> 왼쪽 -> 오른쪽
    public static void preOrderDFS(Node tar){
        if(tar == null) return;
        System.out.print(tar.data + "->");
        preOrderDFS(tar.lt);
        preOrderDFS(tar.rt);
    }

    // 중위 순회(in-order) 루트 -> 왼쪽 -> 오른쪽
    public static void inOrderDFS(Node tar){
        if(tar == null) return;
        inOrderDFS(tar.lt);
        System.out.print(tar.data + "->");
        inOrderDFS(tar.rt);
    }

    // 후위 순회(pro-order) 루트 -> 왼쪽 -> 오른쪽
    public static void proOrderDFS(Node tar){
        if(tar == null) return;
        proOrderDFS(tar.lt);
        proOrderDFS(tar.rt);
        System.out.print(tar.data + "->");
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

        System.out.println("전위");
        preOrderDFS(root);
        System.out.println();
        System.out.println("중위");
        inOrderDFS(root);
        System.out.println();
        System.out.println("후위");
        proOrderDFS(root);
    }
}
