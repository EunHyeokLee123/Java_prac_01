package CodeStudy.solution_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1 ,1 , 1 , 0, 0, -1, -1, -1};

    static void MidTask(int[][] arr, boolean[][] visisted, int x, int y, Point start) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];
                if(newX >= 0 && newX < x && newY >= 0 && newY < y) {
                    if(arr[newY][newX] == 1 && !visisted[newY][newX]) {
                        visisted[newY][newX] = true;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
        }
    }

    static int DFS(int x, int y, int[][] arr) {
        boolean[][] visited = new boolean[y][x];
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    MidTask(arr, visited, x, y, new Point(j, i));
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> resultList = new ArrayList<>();
        while(true) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());
            if(x == 0 && y == 0) {
                break;
            }
            int[][] arr = new int[y][x];
            for (int i = 0; i < y; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < x; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int dfs = DFS(x, y, arr);
            resultList.add(dfs);
        }

        for (Integer i : resultList) {
            System.out.println(i);
        }

        br.close();
    }

}
