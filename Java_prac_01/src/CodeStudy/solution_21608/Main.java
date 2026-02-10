package CodeStudy.solution_21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Stu {
        int num;
        int[] like;
        Stu(int num, int[] arr) {
            this.num = num;
            this.like = arr;
        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] arr;
    static Stu[] stu;
    static Point[] idx;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void getOneStep(Stu now) {
        // 가능한 자리를 담을 리스트
        List<Point> list = new ArrayList<>();
        // 가능한 자리에서 인접한 친구의 값을 저장
        int[][] temp = new int[N + 1][N + 1];
        // 친한 친구 인근의 가능한 자리 모두 탐색
        for (int i = 0; i < 4; i++) {
            if(idx[now.like[i]] != null) {
                Point tp = idx[now.like[i]];
                for(int j = 0; j < 4; j++) {
                    int nx = tp.x + dx[j];
                    int ny = tp.y + dy[j];
                    if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
                        if(temp[nx][ny] == 0) {
                            list.add(new Point(nx, ny));
                            temp[nx][ny] = 1;
                        }
                        else {
                            temp[nx][ny]++;
                        }
                    }
                }
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        stu = new Stu[N * N];
        // 학생들의 위치 저장용
        idx = new Point[N * N + 1];
        for(int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int[] like = new int[4];
            for(int j = 0; j < 4; j++) {
                like[j] = Integer.parseInt(st.nextToken());
            }
            stu[i] = new Stu(a, like);
        }

        // 맨처음 값 넣기
        if(N % 2 == 0) {
            arr[N / 2][N / 2] = stu[0].num;
            idx[stu[0].num] = new Point(N / 2, N / 2);
        }
        else {
            arr[N / 2 + 1][N / 2 + 1] = stu[0].num;
            idx[stu[0].num] = new Point(N / 2 + 1, N / 2 + 1);
        }


        br.close();
    }

}
