package CodeStudy.solution_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }
        br.close();


        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int u = 0; u < size; u++) {
                int cur = queue.poll();
                if(cur == 100) {
                    break;
                }
                for(int i = 1; i < 7; i++) {
                    if(cur + i < 101 && !visited[cur + i]) {
                        visited[cur + i] = true;
                        int up = ladder.getOrDefault(cur + i, -1);
                        int down = snake.getOrDefault(cur + i, -1);
                        if(up != -1) {
                            queue.offer(up);
                            visited[up] = true;
                        }
                        if(down != -1) {
                            queue.offer(down);
                            visited[down] = true;
                        }
                        if(up == -1 && down == -1) {
                            queue.offer(cur + i);
                            visited[cur + i] = true;
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(count);

    }

}
