package CodeStudy.solution_7569;

import java.io.*;
import java.util.*;

public class Main {
    static int x, y, z;
    static int[][][] path;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<int[]> queue = new ArrayDeque<>();

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cz = cur[0], cy = cur[1], cx = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (nz >= 0 && nz < z && ny >= 0 && ny < y && nx >= 0 && nx < x) {
                    if (path[nz][ny][nx] == 0) {
                        path[nz][ny][nx] =  path[cz][cy][cx] + 1;
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }

    public static int getResult() {
        int max = 0;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (path[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, path[i][j][k]);
                }
            }
        }
        return max - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st1.nextToken());
        y = Integer.parseInt(st1.nextToken());
        z = Integer.parseInt(st1.nextToken());

        path = new int[z][y][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    byte val = Byte.parseByte(st.nextToken());
                    path[i][j][k] = val;
                    if (val == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();
        System.out.println(getResult());
    }


}
