package CodeStudy.solution_2573;

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

    static List<Point> OneStep(List<Point> list, int[][] arr, int x, int y) {
        List<Point> result = new ArrayList<>();
        for (Point point : list) {
            int zero = 0;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if(arr[ny][nx] == 0) {
                        zero++;
                    }
                }
            }
            int temp = arr[point.y][point.x] - zero;
            if(temp > 0) {
                result.add(new Point(point.x, point.y));
                arr[point.y][point.x] = temp;
            }
            else {
                arr[point.y][point.x] = 0;
            }
        }
        return result;
    }

    static boolean Decide(List<Point> list, int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[list.size()];
        queue.offer(list.get(0));
        visited[0] = true;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                int nx = poll.x - list.get(i).x;
                int ny = poll.y - list.get(i).y;
                if(nx * nx + ny * ny <= 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(list.get(i));
                }
            }
        }
        // 두 덩이 이상인 경우
        for (boolean b : visited) {
            if (!b) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[y][x];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                int temp  = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp > 0) {
                    list.add(new Point(j, i));
                }
            }
        }

        int result = 0;
        while(true) {
            List<Point> points = OneStep(list, arr, x, y);
            if (points.isEmpty()) {
                result = 0;
                break;
            }
            result++;
            boolean decided = Decide(list, x, y);
            if (decided) break;
        }

        System.out.println(result);

        br.close();

    }

}
