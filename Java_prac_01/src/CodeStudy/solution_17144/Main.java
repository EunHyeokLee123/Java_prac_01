package CodeStudy.solution_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int[][] arr;
    static int time;
    static int[] top;
    static int[] bot;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    // 확산
    static void spread() {
        int[][] temp = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                // 확산이 될 곳
                if(arr[i][j] > 0) {
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >= 0 && ny < R && nx >= 0 && nx < C) {
                            if(arr[ny][nx] != -1) {
                                count++;
                            }
                        }
                    }
                    // 확산될값
                    int add = arr[i][j] / 5;
                    // 확산되고 남을 값
                    int remain = arr[i][j] - add * count;
                    temp[i][j] += remain;
                    // 새로 사용할 배열에 추가될 값을 저장
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >= 0 && ny < R && nx >= 0 && nx < C) {
                            if(arr[ny][nx] != -1) {
                                temp[ny][nx] += add;
                            }
                        }
                    }
                    
                }
                if(arr[i][j] == - 1) {
                    temp[i][j] = -1;
                }
            }
        }

        arr = temp;
    }
    
    // 청정 top
    static void cleanTop() {
        for(int i = top[0] - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        for(int i = 0; i < top[0]; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            arr[top[0]][i] = arr[top[0]][i - 1];
        }
        arr[top[0]][1] = 0;

    }

    // 청정 bottom
    static void cleanBot() {
        for(int i = bot[0] + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        for(int i = R - 1; i > bot[0]; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            arr[bot[0]][i] = arr[bot[0]][i - 1];
        }
        arr[bot[0]][1] = 0;

    }

    // 남아있는 미세먼지 구하기
    static int getTotal() {
        int total = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] > 0) {
                    total += arr[i][j];
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        int idx = 0;
        int[][] cleaner = new int[2][2];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                int tp = Integer.parseInt(st.nextToken());
                // 공기청정기 위치
                if(tp == -1) {
                    cleaner[idx][0] = i;
                    cleaner[idx][1] = j;
                    idx++;
                }
                arr[i][j] = tp;
            }
        }
        
        top = cleaner[0];
        bot = cleaner[1];

        for(int i = 0; i < time; i++) {
            spread();
            cleanTop();
            cleanBot();
        }

        System.out.println(getTotal());

        br.close();
    }

}
