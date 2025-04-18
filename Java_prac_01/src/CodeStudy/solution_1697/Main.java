package CodeStudy.solution_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited = new boolean[100001];
    static ArrayDeque<Integer> queue = new ArrayDeque();

    public static int BFS(int start, int end) {
        int count = 0;
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                if(current == end) {
                    return count;
                }
                else{
                    visited[current] = true;
                    int a1 = current + 1;
                    int a2 = current - 1;
                    int a3 = current * 2;
                    if(a1 <= 100000 && !visited[a1]) {
                        queue.offer(a1);
                    }
                    if(a2 >= 0 && !visited[a2]) {
                        queue.offer(a2);
                    }
                    if(a3 <= 100000 && !visited[a3]) {
                        queue.offer(a3);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = BFS(start, end);
        System.out.println(result);


        br.close();
    }
}
