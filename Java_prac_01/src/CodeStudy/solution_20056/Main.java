package CodeStudy.solution_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Fire {
        int y;
        int x;
        int mass;
        int speed;
        int direction;
        Fire(int y, int x, int mass, int speed, int direction) {
            this.y = y;
            this.x = x;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
        void move(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Point {
        List<Fire> fire = new ArrayList<>();
        Point(Fire f) {
            fire.add(f);
        }
        void clear() {
            fire.clear();
        }
    }

    static int N;
    static int M;
    static Point[][] arr;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] getNext(int x, int y, int dir, int speed) {
        int[] result = new int[2];

        int nx = x + dx[dir] * speed;
        int ny = y + dy[dir] * speed;

        nx %= M;
        ny %= N;

        int tx = 0; int ty = 0;

        if(nx < 1) {
            tx = M + nx;
        }
        else if(nx > M) {
            tx = M - nx;
        }
        else {
            tx = nx;
        }
        if(ny < 1) {
            ty = N + ny;
        }
        else if(ny > N) {
            ty = N - ny;
        }
        else {
            ty = ny;
        }
        result[0] = ty;
        result[1] = tx;
        return result;
    }

    // 이동
    static void move() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(arr[i][j].fire.size() > 0) {
                    List<Fire> temp = new ArrayList<>();
                    for(Fire f : arr[i][j].fire) {
                        int[] next = getNext(f.x, f.y, f.direction, f.speed);
                        Fire tp = new Fire(next[0], next[1], f.mass, f.direction, f.speed);
                        temp.add(tp);
                    }
                    arr[i][j].fire = temp;
                }
            }
        }
    }

    // 파이어볼 병합
    static void match() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                // 해당 칸에 여러개가 있는 경우
                if(arr[i][j].fire.size() > 1) {
                    int w = 0;
                    int sp = 0;
                    int even = 0;
                    for(Fire f : arr[i][j].fire) {
                        w += f.mass;
                        sp += f.speed;
                        if(f.direction % 2 == 0) {
                            even++;
                        }
                    }
                    w /= 5;
                    sp /= arr[i][j].fire.size();
                    boolean flag = false;
                    // 전부 홀수 또는 짝수 인경우 확인
                    if(even == 0 || even == arr[i][j].fire.size()) {
                        flag = true;
                    }
                    // 기존 파이어볼 제거
                    arr[i][j].fire.clear();
                    if(flag) {
                        for(int k = 0; k < 7; k += 2) {
                            int[] next = getNext(j, i, k, 1);
                            arr[next[0]][next[1]].fire.add(new Fire());
                        }
                    }
                    else {

                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        arr = new Point[N + 1][M + 1];

        while(true) {
            String temp = br.readLine();
            if(temp == null) break;
            st = new StringTokenizer(temp, " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fire fire = new Fire(y, x, m, s, d);
            arr[y][x].fire.add(fire);
        }



        br.close();
    }

}
