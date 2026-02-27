package CodeStudy.solution_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        Point now;
        int mass;
        int count;
        public Shark(int x, int y) {
            this.now = new Point(x, y);
            this.mass = 2;
            this.count = 0;
        }
        public void eat() {
            count++;
            if(count == mass) {
                mass++;
                count = 0;
            }
        }
    }

    static int N;
    static int[][] arr;
    static Shark shark;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int BFS() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(shark.now);
        boolean[][] visited = new boolean[N][N];
        visited[shark.now.y][shark.now.x] = true;
        Point tar = null;
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 현재 탐색점들중에 먹을 수 있는 것이 있는 지 확인
            boolean flag = false;
            for(int u = 0; u < size; u++) {
                Point p = queue.poll();
                // 먹을 수 있으면
                if(shark.mass > arr[p.y][p.x] && arr[p.y][p.x] > 0) {
                    flag = true;
                    if(tar == null) {
                        tar = p;
                    }
                    else {
                        if(p.y < tar.y) {
                            tar = p;
                        }
                        else if(p.y == tar.y) {
                            if(p.x < tar.x) {
                                tar = p;
                            }
                        }
                    }
                }

                if(!flag) {
                    for(int t = 0; t < 4; t++) {
                        int nx = p.x + dx[t];
                        int ny = p.y + dy[t];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                            // 빈칸이거나 무게가 같거나 작은 경우만 이동가능
                            if(shark.mass >= arr[ny][nx]) {
                                visited[ny][nx] = true;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
            if(flag) break;
            time++;
        }
        shark.now = tar;
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp == 9) {
                    shark = new Shark(j, i);
                    arr[i][j] = 0;
                }
            }
        }

        int result = 0;
        while(true) {
            int time = BFS();
            // 더이상 먹을 것이 없는 경우
            if(shark.now == null) {
                break;
            }
            else {
                shark.eat();
                arr[shark.now.y][shark.now.x] = 0;
                result += time;
            }
        }

        System.out.println(result);

        br.close();
    }

}
