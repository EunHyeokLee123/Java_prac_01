package CodeStudy.solution_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Fire {
        int mass;
        int speed;
        int dir;
        Fire(int mass, int speed, int des) {
            this.mass = mass;
            this.speed = speed;
            this.dir = des;
        }
    }

    static class Point {
        List<Fire> list = new ArrayList<>();
    }

    static int N;
    static int M;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Point[][] arr;

    static int[] getNext(int x, int y, int dir, int speed) {
        int[] result = new int[2];

        int nx = x + dx[dir] * (speed % N);
        int ny = y + dy[dir] * (speed % N);

        nx %= N;
        ny %= N;

        int tx = 0; int ty = 0;

        if(nx < 1) {
            tx = N + nx;
        }
        else if(nx > N) {
            tx = N - nx;
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

    static void move() {
        Point[][] temp = new Point[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                temp[i][j] = new Point();
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j].list.size() > 0) {
                    for(int k = 0; k < arr[i][j].list.size(); k++) {
                        Fire tp = arr[i][j].list.get(k);
                        int[] next = getNext(j, i, tp.dir, tp.speed);
                        temp[next[0]][next[1]].list.add(tp);
                    }
                }
            }
        }

        arr = temp;
    }
    
    static void gather() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // 병합이 일어나는 케이스만
                if(arr[i][j].list.size() > 1) {
                    int tm = 0;
                    int ts = 0;
                    int odd = 0;
                    for(int k = 0; k < arr[i][j].list.size(); k++) {
                        Fire tp = arr[i][j].list.get(k);
                        tm += tp.mass;
                        ts += tp.speed;
                        if(tp.dir % 2 == 1) {
                            odd++;
                        }
                    }
                    tm /= 5;
                    ts /= arr[i][j].list.size();
                    // 방향이 0, 2, 4, 6
                    // 리스트 비우기
                    if(tm != 0) {
                        if(odd == 0 || odd == arr[i][j].list.size()) {
                            arr[i][j].list.clear();
                            for(int t = 0; t < 7; t += 2) {
                                arr[i][j].list.add(new Fire(tm, ts, t));
                            }
                        }
                        // 방향이 1, 3, 5, 7
                        else {
                            arr[i][j].list.clear();
                            for(int t = 1; t < 8; t += 2) {
                                arr[i][j].list.add(new Fire(tm, ts, t));
                            }
                        }
                    }
                    else {
                        arr[i][j].list.clear();
                    }
                }
            }
        }
    }

    static int getResult() {
        int result = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j].list.size() > 0) {
                    for(int k = 0; k < arr[i][j].list.size(); k++) {
                        result += arr[i][j].list.get(k).mass;
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Point[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = new Point();
            }
        }
        int len = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[y][x].list.add(new Fire(m, s, d));
        }


        for(int i = 0; i < len; i++) {
            move();
            gather();
        }

        System.out.println(getResult());

        br.close();
    }

}
