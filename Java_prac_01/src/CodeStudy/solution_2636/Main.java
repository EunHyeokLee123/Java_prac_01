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
    static Queue<Point> queue = new LinkedList<Point>();

    public static boolean BFS(int time) {
        int size = queue.size();
        boolean flag = false;
        boolean[][] visited = new boolean[y][x];
        queue.offer(new Point(0, 0));
        while(size > 0){
            Point p = queue.poll();
            visited[p.y][p.x] = true;
            for (int i = 0; i < 4; i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < x && ty < y){
                    if(arr[ty][tx] == 0 && !visited[ty][tx]){
                        queue.offer(new Point(tx, ty));
                    }
                    if(arr[ty][tx] == 1){
                        flag = true;
                        arr[ty][tx] = time + 1;
                        cheeseCount--;
                    }
                }
            }
            size --;
        }
        return flag;
    }

    public static int findPrevLast(int tarTime) {
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(arr[i][j] == tarTime){
                    count++;
                }
            }
        }
        return count;
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
        int time = 1;
        while(cheeseCount > 0){
            boolean flag = BFS(time);
            if(flag) time++;
        }

        int last = findPrevLast(time - 1);
        System.out.println(time - 1);
        System.out.println(last);

        br.close();
    }

}
