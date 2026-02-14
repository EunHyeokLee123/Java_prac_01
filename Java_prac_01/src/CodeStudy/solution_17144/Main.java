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
                        int ny = i + dy[i];
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
                        int ny = i + dy[i];
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

    }

    // 청정 bottom
    static void cleanBot() {

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



        br.close();
    }

}
