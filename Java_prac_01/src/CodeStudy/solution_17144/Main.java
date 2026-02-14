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
                    int add = Math.ceilDiv(arr[i][j], count);
                    // 확산되고 남을 값
                    int remain = arr[i][j] - add * count;
                    arr[i][j] = remain;
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
            }
        }

        // temp에 추가되는 값이 저장되고 나면 arr에 남아있는 remain들을 temp에 저장해야 함.
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] > 0) {
                    temp[i][j] += arr[i][j];
                }
            }
        }

        arr = temp;
    }
    
    // 청정 top
    static void cleanTop() {
        // 반대로 생각하자
        // 시계방향으로 한칸씩 땡겨진다고 하자.
        arr[top[0] - 1][top[1]] = 0;
        for(int i = top[0] + 1; i > 0; i--) {
            arr[i][top[1]] = arr[i - 1][top[1]];
        }
        // 최상단
        for(int i = top[1]; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }

        for (int i = 0; i < top[0] - 1; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }

        for(int i = C - 1; i < top[1] + 1; i--) {
            arr[top[0]][i] = arr[top[0]][i - 1];
        }

        arr[top[0]][top[1] + 1] = 0;
    }

    // 청정 bottom
    static void cleanBot() {
        // 반대로 생각하자
        // 반시계방향으로 한칸씩 땡겨진다고 하자.
        arr[bot[0] + 1][bot[1]] = 0;
        for(int i = bot[0] + 1; i < R - 1; i++) {
            arr[i][bot[1]] = arr[i + 1][bot[1]];
        }
        for(int i = bot[1]; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        for(int i = R - 1; i > bot[0] + 1; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for(int i = C - 1; i > bot[1] + 1; i--) {
            arr[bot[0]][i] = arr[bot[0]][i - 1];
        }

        arr[bot[0]][bot[1] + 1] = 0;
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
        int[] temp = new int[2];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                int tp = Integer.parseInt(st.nextToken());
                // 공기청정기 위치
                if(tp == -1) {
                    temp[0] = i;
                    temp[1] = j;
                }
                arr[i][j] = tp;
            }
        }
        
        top = new int[]{temp[0] - 1, temp[1]};
        bot = new int[]{temp[0], temp[1]};

        for(int i = 0; i < time; i++) {
            spread();
            cleanTop();
            cleanBot();
        }

        System.out.println(getTotal());

        br.close();
    }

}
