package CodeStudy.solution_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        Node prev;
        int value;
        Node(Node prev, int value) {
            this.prev = prev;
            this.value = value;
        }
    }

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Node startNode = new Node(null, start);
        boolean[] visited = new boolean[MAX];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode.value] = true;
        int time = 0;
        Node last = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.value == target) {
                    flag = true;
                    last = node;
                    break;
                }
                if(node.value - 1 >= 0 && !visited[node.value - 1]) {
                    visited[node.value - 1] = true;
                    Node temp = new Node(node,  node.value - 1);
                    queue.offer(temp);
                }
                if(node.value + 1 <= target && !visited[node.value + 1]) {
                    visited[node.value + 1] = true;
                    Node temp = new Node(node,  node.value + 1);
                    queue.offer(temp);
                }
                if(node.value * 2 < MAX && !visited[node.value * 2]) {
                    visited[node.value * 2] = true;
                    Node temp = new Node(node,  node.value * 2);
                    queue.offer(temp);
                }
            }
            if(flag) break;
            time++;
        }

        System.out.println(time);

        List<Integer> list = new ArrayList<>();

        while(true) {
            if(last.prev != null) {
                list.add(last.value);
                last = last.prev;
            }
            else {
                break;
            }
        }

        list.add(start);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.printf("%d ", list.get(i));
        }

        br.close();
    }

}
