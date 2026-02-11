package CodeStudy.solution_21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Oper {
        int way;
        int step;
        public Oper(int way, int step) {
            this.way = way;
            this.step = step;
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] arr;
    static List<Point> cloud;
    static boolean[][] visit;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] tx = {-1, -1, 1, 1};
    static int[] ty = {-1, 1, -1, 1};

    // 다음 좌표 계산기
    static Point getNext(Oper op, Point now) {
        int nx = now.x + dx[op.way - 1] * op.step;
        int ny = now.y + dy[op.way - 1] * op.step;

        nx %= N; ny %= N;

        if(nx < 1) {
            nx = N + nx;
        }
        else if(nx > N) {
            nx = nx - N;
        }
        if(ny < 1) {
            ny = N + ny;
        }
        else if(ny > N) {
            ny = ny - N;
        }
        return new Point(nx, ny);
    }

    // 비 내리기
    static void doRain() {
        for(int i = 0; i < cloud.size(); i++) {
            arr[cloud.get(i).y][cloud.get(i).x]++;
        }
    }

    // 대각선 좌표에 물개수 계산기
    static int isWater(Point now) {
        int count = 0;

        for(int i = 0; i < 4; i++) {
            int nx = now.x + tx[i];
            int ny = now.y + ty[i];
            if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
                if(arr[ny][nx] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 물 버그
    static void doWater() {
        // 물이 증가할 양을 저장
        int[] temp = new int[cloud.size()];
        for(int i = 0; i < cloud.size(); i++) {
            Point now = cloud.get(i);
            temp[i] = isWater(now);
        }
        for(int i = 0; i < cloud.size(); i++) {
            arr[cloud.get(i).y][cloud.get(i).x] += temp[i];
        }
    }

    // 새로운 구름 생성
    static void doLast() {
        List<Point> nc = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // 구름이 생성되는 지 여부 확인
                if(arr[i][j] >= 2) {
                    // 사라질 구름인지
                    if(!visit[i][j]) {
                        nc.add(new Point(j ,i));
                        arr[i][j] -= 2;
                    }
                }
            }
        }

        // 기존 구름 제거
        for(int i = 0; i < cloud.size(); i++) {
            visit[cloud.get(i).y][cloud.get(i).x] = false;
        }

        cloud.clear();
        cloud = nc;
    }

    static int getResult() {
        int result = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                result += arr[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Oper[] op  = new Oper[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            op[i] = new Oper(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        cloud = new ArrayList<>();
        cloud.add(new Point(1, N));
        cloud.add(new Point(2, N));
        cloud.add(new Point(1, N - 1));
        cloud.add(new Point(2, N - 1));

        for(int i = 0; i < op.length; i++) {
            // 구름 이동
            List<Point> nc = new ArrayList<>();
            for(int j = 0; j < cloud.size(); j++) {
                Point temp = cloud.get(j);
                Point moved = getNext(op[i], temp);
                visit[moved.y][moved.x] = true;
                nc.add(moved);
            }
            cloud = nc;
            // 비 내리기
            doRain();
            // 물버그
            doWater();
            // 새로운 구름 생성 및 기존 구름 제거
            doLast();
        }

        System.out.println(getResult());

        br.close();
    }

}
