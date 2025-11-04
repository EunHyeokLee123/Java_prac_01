package CodeStudy.solution_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(3); queue.offer(5);
        boolean can = true;
        int result = 0;
        boolean[] visited = new boolean[5001];
        visited[3] = visited[5] = true;
        while(!queue.isEmpty()) {
            result++;
            // queue에 있는 숫자들중 하나라도 target보다 작다면 true
            boolean temp = false;
            // target을 찾았다면 true
            boolean flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now == target) {
                    flag = true;
                    break;
                }
                if(now < target) {
                    // target보다 작은 값이 있었음
                    temp = true;
                    if(now + 3 <= 5000 && !visited[now + 3]) {
                        queue.offer(now + 3);
                        visited[now + 3] = true;
                    }
                    if(now + 5 <= 5000 && !visited[now + 5]) {
                        queue.offer(now + 5);
                        visited[now + 5] = true;
                    }
                }
            }
            if(flag) break;
            // queue에 있던 값이 모두 컸던 경우
            if(!temp) {
                can = false;
                break;
            }
        }

        if(!can) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }


        br.close();
    }

}
