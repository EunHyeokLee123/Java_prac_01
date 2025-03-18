package dfs;

public class Node {
    Node lt;
    Node rt;
    int data;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}
