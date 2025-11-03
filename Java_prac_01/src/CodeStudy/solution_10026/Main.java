package CodeStudy.solution_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 상하좌우 탐색용 배열 2개
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] arr;
    static boolean[][] visited;
    static int length;

    // option이 true -> 적록색약
    // option이 false -> 적록색약 X
    static boolean BFS(Point start, boolean option) {
        // 이미 방문한 점에서 시작하는 경우 탐색 종료
        if(visited[start.y][start.x]) {
            return false;
        }

        visited[start.y][start.x] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            // 혹시 모를 방문처리 한번더
            visited[curr.y][curr.x] = true;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx >= 0 && nx < length && ny >= 0 && ny < length) {
                    // 탐색대상의 점이 방문하지 않은 점인 경우
                    if(!visited[ny][nx]) {
                        // 적록색약인 경우
                        // r,g랑 같은 취급
                        if(option) {
                            // 현재 점이 B인 경우
                            if(arr[curr.y][curr.x] == 'B') {
                                // B일때만 탐색범위 추가
                                if(arr[ny][nx] == 'B') {
                                    queue.add(new Point(nx, ny));
                                }
                            }
                            // 현재 점이 R, G인 경우
                            else {
                                if(arr[ny][nx] == 'R' || arr[ny][nx] == 'G') {
                                    queue.add(new Point(nx, ny));
                                }
                            }
                            // 해당 점 방문 처리
                            visited[ny][nx] = true;
                        }
                        // 적록색약이 아닌 경우
                        else {
                            if (arr[curr.y][curr.x] == 'R') {
                                if(arr[ny][nx] == 'R') {
                                    queue.add(new Point(nx, ny));
                                }
                            }
                            else if (arr[curr.y][curr.x] == 'G') {
                                if(arr[ny][nx] == 'G') {
                                    queue.add(new Point(nx, ny));
                                }
                            }
                            else {
                                if(arr[ny][nx] == 'B') {
                                    queue.add(new Point(nx, ny));
                                }
                            }
                            // 해당 점 방문 처리
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
        // 한 점이라도 탐색을 했다면 true
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        visited = new boolean[length][length];
        arr = new char[length][length];
        for (int i = 0; i < length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < length; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        int yes = 0;
        int no = 0;

        // option -> true
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(BFS(new Point(j, i), true)) {
                    yes++;
                }
            }
        }

        // 방문배열 초기화
        visited = new boolean[length][length];
        // option -> false
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(BFS(new Point(j, i), false)) {
                    no++;
                }
            }
        }

        System.out.printf("%d %d\n", no, yes);

        br.close();
    }

}
