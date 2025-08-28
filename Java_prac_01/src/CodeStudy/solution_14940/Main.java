package CodeStudy.solution_14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

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

    static int[][] BFS(int x, int y, int[][] arr, Point start, int[][] result) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[y][x];
        queue.offer(start);
        visited[start.y][start.x] = true;
        result[start.y][start.x] = 0;
        int steps = 0;
        while (!queue.isEmpty()) {
            int time = queue.size();
            steps++;
            for (int i = 0; i < time; i++) {
                Point cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if(nx >= 0 && nx < x && ny >= 0 && ny < y) {
                        if(!visited[ny][nx] && arr[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            result[ny][nx] = steps;
                            queue.offer(new Point(nx, ny));
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
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];
        int[][] result = new int[y][x];
        Point start = null;
        for (int i = 0; i < y; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                int temp = Integer.parseInt(st1.nextToken());
                if (temp == 2) {
                    start = new Point(j, i);
                    result[i][j] = 0;
                }
                else if (temp == 1) {
                    result[i][j] = -1;
                }
                arr[i][j] = temp;
            }
        }

        int[][] bfs = BFS(x, y, arr, start, result);
        // 그냥 배열을 print 하는 것보다
        // StringBuilder로 만들어서 출력하는 것이 더 시간이 적게 든다!
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(bfs[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
