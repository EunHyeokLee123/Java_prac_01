package CodeStudy.solution_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 탐색 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean BFS(int[][] arr,
                    int length, int max, int min) {
        // 국경이 열렸는 지에 대한 여부
        boolean result = false;
        // 해당 점 방문 여부 저장
        boolean[][] visited = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(!visited[i][j]) {
                    List<Point> points
                            = MinorStep(arr, visited, new Point(j, i), length, max, min);
                    // 국경이 열려서 연합이 되는 경우
                    if(points.size() > 1) {
                        // 연합 여부 true로
                        result = true;
                        int sum = 0;
                        for (Point point : points) {
                            sum += arr[point.y][point.x];
                        }
                        int remain = sum / points.size();
                        for (Point point : points) {
                            arr[point.y][point.x] = remain;
                        }
                    }
                }
            }
        }
        return result;
    }

    static List<Point> MinorStep(int[][] arr , boolean[][] visited,
                                 Point now, int length, int max, int min) {

        Queue<Point> queue = new ArrayDeque<>();
        List<Point> result = new ArrayList<>();
        queue.offer(now);
        result.add(now);
        visited[now.y][now.x] = true;
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.y][point.x] = true;
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                // 탐색 대상 좌표의 유효성 확인
                if(newX >= 0 && newX < length && newY >= 0 && newY < length) {
                    // 방문 여부 확인
                    if(!visited[newY][newX]) {
                        int diff = Math.abs(arr[newY][newX] - arr[point.y][point.x]);
                        // 국경 개방 조건 확인
                        if(diff >= min && diff <= max) {
                            visited[newY][newX] = true;
                            queue.offer(new Point(newX, newY));
                            result.add(new Point(newX, newY));
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                // y, x
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        while(true) {
            boolean opened = BFS(arr, length, max, min);
            if(!opened) break;
            idx++;
        }

        System.out.println(idx);

        br.close();

    }

}
