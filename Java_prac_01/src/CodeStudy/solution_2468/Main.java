package CodeStudy.solution_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    static int BFS (Point[][] arr, int length, int limit) {
        Queue<XY> queue = new LinkedList<>();
        int step = 0;
        while(true) {
            XY start = findFirst(arr, limit, length);
            if(start == null) {
                break;
            }
            step++;
            queue.offer(start);
            while (!queue.isEmpty()) {
                XY now = queue.poll();
                arr[now.y][now.x].visited = true;
                for (int i = 0; i < 4; i++) {
                    int newX = now.x + dx[i];
                    int newY = now.y + dy[i];
                    if (newX >= 0 && newX < length && newY >= 0 && newY < limit) {
                        if (arr[newY][newX].value > limit && !arr[newY][newX].visited) {
                            queue.offer(new XY(newX, newY));
                            arr[newY][newX].visited = true;
                        }
                    }
                }
            }
        }
        return step;
    }
    
    // 해당 높이에서 탐색을 해야할 점을 찾음
    static XY findFirst(Point[][] arr, int height, int length) {
        // y
        for (int i = 0; i < length; i++) {
            // x
            for (int j = 0; j < length; j++) {
                if(arr[i][j].value > height && arr[i][j].visited == false) {
                    // {y, x}
                    return new XY(j, i);
                }
            }
        }
        return null;
    }
    
    // 한 높이에서 끝나면 visited 다시 전부 false로 바꿈
    static void NewStart(Point[][] arr, int length, int height) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(arr[i][j].value > height) {
                    if(arr[i][j].visited == true) {
                        arr[i][j].visited = false;
                    }
                }
            }
        }
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

            int midResult = BFS(arr, length, now);
            if(midResult > result) {
                result = midResult;
            }
            NewStart(arr, length, now);
            now++;

        }
        System.out.println(result);

        br.close();
    }

}
