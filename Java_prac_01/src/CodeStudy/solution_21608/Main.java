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

    static class Score {
        int like;
        int blank;
        int x;
        int y;
        Score(int like, int blank, int x, int y) {
            this.like = like;
            this.blank = blank;
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] arr;
    static int[] follow;
    static Stu[] stu;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 가능한 모든 점의 점수를 채점
    static Score[][] getOneStep(Stu stu) {
        Score[][] all = new Score[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] == 0) {
                    int zero = 0;
                    int like = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
                            if(arr[ny][nx] == 0) {
                                zero++;
                            }
                            else {
                                for(int t = 0; t < 4; t++) {
                                    if(arr[ny][nx] == stu.like[t]) {
                                        like++;
                                    }
                                }
                            }
                        }
                    }
                    Score temp = new Score(like, zero, j, i);
                    all[i][j] = temp;
                }
                else {
                    all[i][j] = null;
                }
            }
        }
        return all;
    }

    static int[] getPoint(Score[][] score) {
        // y, x 순으로 저장
        int[] result = new int[2];
        Score start = null;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(score[i][j] != null) {
                    if(start == null) {
                        start = score[i][j];
                    }
                    else {
                        // 1단계 확인
                        if(score[i][j].like > start.like) {
                            start = score[i][j];
                        }
                        // 같은 경우
                        else if(score[i][j].like == start.like) {
                            // 2단계 확인
                            if(score[i][j].blank > start.blank) {
                                start = score[i][j];
                            }
                            else if(score[i][j].blank == start.blank) {
                                // 3단계 확인
                                if(i < start.y) {
                                    start = score[i][j];
                                }
                                else if(i == start.y) {
                                    if(j < start.x) {
                                        start = score[i][j];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        result[0] = start.y;
        result[1] = start.x;

        return result;
    }

    // num은 학생 번호
    static void doLast(int[] idx, int num) {
        arr[idx[0]][idx[1]] = num;
    }

    static int getScore() {
        int result = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int count = 0;
                Stu now = stu[arr[i][j]];
                for(int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
                        for(int t = 0; t < 4; t++) {
                            if(arr[ny][nx] == now.like[t]) {
                                count++;
                            }
                        }
                    }
                }
                if(count > 0) {
                    result += (int) Math.pow(10, count - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        stu = new Stu[N * N + 1];
        follow = new int[N * N + 1];
        for(int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int[] like = new int[4];
            for(int j = 0; j < 4; j++) {
                like[j] = Integer.parseInt(st.nextToken());
            }
            stu[a] = new Stu(a, like);
            follow[i + 1] = a;
        }

        for(int i = 1; i < follow.length; i++) {
            Stu now = stu[follow[i]];
            Score[][] te = getOneStep(now);
            int[] idx = getPoint(te);
            doLast(idx, now.num);
        }

        int score = getScore();

        System.out.println(score);

        br.close();
    }

}
