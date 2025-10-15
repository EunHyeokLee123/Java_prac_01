package CodeStudy.solution_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        if(start == target) {
            System.out.println(0);
        }
        else if (start > target) {
            System.out.println(start - target);
        }
        else {
            int time = 0;
            boolean[] visited = new boolean[MAX];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    int now =  queue.poll();
                    int idx = 1;
                    // 순간이동한 곳들 전부 방문 처리
                    while(now * (int) Math.pow(2, idx) < MAX && now > 0) {
                        // 순간이동한 곳이 target이면
                        if(now * (int) Math.pow(2, idx) == target) {
                            flag = true;
                        }
                        // 방문하지 않았다면
                        if(!visited[now * (int) Math.pow(2, idx)]) {
                            queue.offer(now * (int) Math.pow(2, idx));
                            visited[now * (int) Math.pow(2, idx)] = true;
                        }
                        idx++;
                    }
                    // 첫 위치 다시 queue에 넣기
                    queue.offer(now);
                }
                // 찾았다면 탐색 종료
                if(flag) break;
                time++;
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    int now =  queue.poll();
                    // +1, -1에 target 있다면
                    if(now - 1 == target || now + 1 == target) {
                        flag = true;
                    }
                    if(now - 1 >= 0 && !visited[now - 1]) {
                        queue.offer(now - 1);
                        visited[now - 1] = true;
                    }
                    if(now + 1 < MAX && !visited[now + 1]) {
                        queue.offer(now + 1);
                        visited[now + 1] = true;
                    }
                }
                if(flag) break;
            }
            System.out.println(time);
        }

        br.close();
    }

}
