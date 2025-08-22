package CodeStudy.solution_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int value;
        boolean visited;
        public Point(int value) {
            this.value = value;
            this.visited = false;
        }
    }

    static class XY {
        int x;
        int y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*static boolean BFS(Point[][] arr, int heigth, int length) {

    }*/
    
    // 해당 높이에서 탐색을 해야할 점을 찾음
    static int[] findFirst(Point[][] arr, int height, int length) {
        // y
        for (int i = 0; i < length; i++) {
            // x
            for (int j = 0; j < length; j++) {
                if(arr[i][j].value > height && arr[i][j].visited == false) {
                    // {y, x}
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }
    
    // 한 높이에서 끝나면 visited 다시 전부 false로 바꿈
    static Point[][] NewStart(Point[][] arr, int length, int height) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(arr[i][j].value > height) {
                    if(arr[i][j].visited == true) {
                        arr[i][j].visited = false;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        // y, x
        Point[][] arr = new Point[length][length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                int input = Integer.parseInt(st.nextToken());
                arr[i][j] = new Point(input);
                if(input > max) {
                    max = input;
                }
            }
        }

        // 최대 조각 수
        int result = 0;
        // 현재 탐색 높이
        int now = 1;
        // 1부터 높이 최대값까지 탐색을 하자
        while(now <= max) {

            int[] start = findFirst(arr, arr.length, now);


        }




        br.close();
    }

}
