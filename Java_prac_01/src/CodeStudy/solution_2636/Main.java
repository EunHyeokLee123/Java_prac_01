package CodeStudy.solution_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int x;
    static int y;
    static int[][] arr;
    static int cheeseCount;

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < x && ty < y && !visited[ty][tx]){
                    visited[ty][tx] = true;
                    if(arr[ty][tx] == 0){
                        queue.offer(new Point(tx, ty));
                    }
                    if(arr[ty][tx] == 1){
                        arr[ty][tx] = 0;
                        cheeseCount--;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];
        cheeseCount = 0;
        for (int i = 0; i < y; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
                if(arr[i][j] == 1){
                    cheeseCount++;
                }
            }
        }
        int time = 0; int restCheese = 0;
        while(cheeseCount != 0){
            time++;
            restCheese = cheeseCount;
            BFS();
        }

        System.out.println(time);
        System.out.println(restCheese);

        br.close();
    }

}
