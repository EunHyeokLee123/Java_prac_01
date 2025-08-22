package CodeStudy.solution_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static void BFS(int[][] arr, boolean[][] visited, int length, int limit, Point start) {

        Queue<Point> queue = new LinkedList<>();
            // 찾으면 넣기
            queue.offer(start);
            visited[start.y][start.x] = true;
            while(!queue.isEmpty()) {
                Point temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = temp.x + dx[i];
                    int newY = temp.y + dy[i];
                    if(newX >= 0 && newX < length && newY >= 0 && newY < length) {
                        if(arr[newY][newX] > limit && !visited[newY][newX]) {
                            visited[newY][newX] = true;
                            queue.offer(new Point(newX, newY));
                        }
                    }
                }
            }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        // y, x
        int[][] arr = new int[length][length];
        int min = 101;
        int max = 0;
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp > max) {
                   max = temp;
                }
                else if (temp < min) {
                    min = temp;
                }
            }
        }
        int result = 1;
        int idx = min - 1;
        while(idx <= max + 1) {
            boolean[][] visited = new boolean[length][length];
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(arr[i][j] > idx && !visited[i][j]) {
                        BFS(arr, visited, length, idx, new Point(j, i));
                        cnt++;
                    }
                }
            }
            if(cnt > result) {
                result = cnt;
            }
            idx++;
        }

        System.out.println(result);

        br.close();
    }

}
