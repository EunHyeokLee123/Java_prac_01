package CodeStudy.solution_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int[] red = new int[2];
        int[] blue = new int[2];
        public Node(int rx, int ry, int bx, int by) {
            red[0] = ry;
            red[1] = rx;
            blue[0] = by;
            blue[1] = bx;
        }
    }

    static int N;
    static int M;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 1이면 레드, 2면 블루
    static int whichFirst(int[] red, int[] blue, int idx) {
        // 좌
        if(idx == 0) {
            // x가 작은거
            if(red[1] <= blue[1]) {
                return 1;
            }
            else {
                return 2;
            }
        }
        // 우
        else if (idx == 1) {
            if(red[1] >= blue[1]) {
                return 1;
            }
            else {
                return 2;
            }
        }
        // 상
        else if (idx == 2) {
            if(red[0] <= blue[0]) {
                return 1;
            }
            else {
                return 2;
            }
        }
        // 하
        else {
            if(red[0] >= blue[0]) {
                return 1;
            }
            else {
                return 2;
            }
        }
    }


    // idx는 움직이는 방향
    // 0 좌, 1 우, 2 상, 3 하
    static Node Move(int[] red, int[] blue, int idx) {
        int start = whichFirst(red, blue, idx);
        int ry = red[0];
        int rx = red[1];
        int by = blue[0];
        int bx = blue[1];
        // 레드 먼저
        if(start == 1) {
            while(true) {
                ry += dy[idx];
                rx += dx[idx];
                // 벽에 다다르면
                if(arr[ry][rx] == '#') {
                    rx -= dx[idx];
                    ry -= dy[idx];
                    break;
                }
                // 구멍에 다다르면
                else if(arr[ry][rx] == 'O') {
                    break;
                }
            }
            while(true) {
                bx += dx[idx];
                by += dy[idx];
                if(arr[by][bx] == '#') {
                    bx -= dx[idx];
                    by -= dy[idx];
                    break;
                }
                else if(arr[by][bx] == 'O') {
                    break;
                }
                // 빨간 구슬이랑 겹치면
                // 바로 이전 곳으로 이동
                else if(by == ry && bx == rx) {
                    bx -= dx[idx];
                    by -= dy[idx];
                    break;
                }
            }
        }
        // 블루 먼저
        else {
            // 블루 움직임
            while(true) {
                by += dy[idx];
                bx += dx[idx];
                // 벽에 다다르면
                if(arr[by][bx] == '#') {
                    bx -= dx[idx];
                    by -= dy[idx];
                    break;
                }
                // 구멍에 다다르면
                else if(arr[by][bx] == 'O') {
                    break;
                }
            }
            // 빨강 움직임
            while(true) {
                rx += dx[idx];
                ry += dy[idx];
                if(arr[ry][rx] == '#') {
                    rx -= dx[idx];
                    ry -= dy[idx];
                    break;
                }
                else if(arr[ry][rx] == 'O') {
                    break;
                }
                // 빨간 구슬이랑 겹치면
                // 바로 이전 곳으로 이동
                else if(by == ry && bx == rx) {
                    rx -= dx[idx];
                    ry -= dy[idx];
                    break;
                }
            }
        }
        return new Node(rx, ry, bx, by);
    }

    static int BFS(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        // 앞에 2개는 red, 뒤에 2개는 blue
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[start.red[0]][start.red[1]][start.blue[0]][start.blue[1]] = true;
        int times = 0;
        while (!queue.isEmpty()) {
            if(times == 11) {
                break;
            }
            int size = queue.size();
            boolean flag = false;
            for(int q = 0; q < size; q++) {
                Node cur = queue.poll();
                // 성공여부 확인
                if(arr[cur.red[0]][cur.red[1]] == 'O') {
                    flag = true;
                    break;
                }

                // 다음 탐색 진행
                for(int i = 0; i < 4; i++) {
                    Node temp = Move(cur.red, cur.blue, i);
                    // 이동이 없는 경우 skip
                    if(temp.red[0] == cur.red[0] &&
                            temp.red[1] == cur.red[1] &&
                            temp.blue[0] == cur.blue[0] &&
                            temp.blue[1] == cur.blue[1]){
                        continue;
                    }
                    if(!visited[temp.red[0]][temp.red[1]][temp.blue[0]][temp.blue[1]]) {
                        if(arr[temp.blue[0]][temp.blue[1]] == 'O') {
                            continue;
                        }
                        queue.offer(temp);
                        visited[temp.red[0]][temp.red[1]][temp.blue[0]][temp.blue[1]] = true;
                    }
                }

            }
            if(flag) {
                return times;
            }
            times++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                arr[i][j] = line[j];
                if(line[j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                else if(line[j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
            }
        }

        Node start = new Node(red[1], red[0], blue[1], blue[0]);

        int bfs = BFS(start);

        if(bfs == 11) {
            System.out.println(-1);
        }
        else if(bfs == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(bfs);
        }

        br.close();
    }

}
