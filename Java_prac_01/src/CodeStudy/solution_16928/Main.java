package CodeStudy.solution_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> route = new HashMap<>();
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
            route.put(start, end);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            route.put(start, end);
        }
        br.close();


        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for(int u = 0; u < size; u++) {
                int cur = queue.poll();
                if(cur == 100) {
                    flag = true;
                    break;
                }
                for(int i = 1; i < 7; i++) {
                    if(cur + i < 101 && !visited[cur + i]) {
                        visited[cur + i] = true;
                        int way = route.getOrDefault(cur + i, -1);
                        if(way == -1) {
                            queue.offer(cur + i);
                        }
                        else {
                            if(!visited[way]) {
                                queue.offer(way);
                                visited[way] = true;
                            }
                        }
                    }
                }
            }
            if(flag) break;
            count++;
        }
        System.out.println(count);

    }

}
