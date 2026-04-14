package CodeStudy.solution_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        String now;
        Node(int x, int y, String now) {
            this.x = x;
            this.y = y;
            this.now = now;
        }
    }

    static boolean canGo(String line, char to) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == to) {
                return false;
            }
        }
        return true;
    }

    static int R;
    static int C;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;
    static boolean[] visited = new boolean[26];

    static void DFS(int x, int y, int len) {
        result = Math.max(result, len);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

            if(!visited[arr[ny][nx] - 'A']) {
                visited[arr[ny][nx] - 'A'] = true;
                DFS(nx, ny, len + 1);
                visited[arr[ny][nx] - 'A'] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        br.close();
        visited[arr[0][0] - 'A'] = true;
        DFS(0, 0, 1);

        System.out.println(result);

    }

}
