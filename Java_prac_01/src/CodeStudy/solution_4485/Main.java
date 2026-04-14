package CodeStudy.solution_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, y, cost;
        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static List<Integer> result = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
                return a.cost - b.cost;
            });

            dist[0][0] = arr[0][0];
            pq.offer(new Point(0, 0, dist[0][0]));
            while (!pq.isEmpty()) {
                Point cur = pq.poll();

                // 현재 포인트의 비용값이 탐색할 가치가 없으면
                // 그냥 넘김
                if(cur.cost > dist[cur.y][cur.x]) {
                    continue;
                }

                for(int u = 0; u < 4; u++) {
                    int nx = cur.x + dx[u];
                    int ny = cur.y + dy[u];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        int next = cur.cost + arr[ny][nx];

                        if(next < dist[ny][nx]) {
                            dist[ny][nx] = next;
                            pq.offer(new Point(nx, ny, next));
                        }
                    }
                }
            }
            result.add(dist[n - 1][n - 1]);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append("Problem " + (i + 1) + ": " + result.get(i) + "\n");
        }

        System.out.println(sb);
    }

}
