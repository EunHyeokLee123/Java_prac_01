package CodeStudy.solution_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static boolean check(int x, int y, int value) {
        // 가로
        for (int i = 0; i < 9; i++) {
            if(arr[i][x] == value){
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if(arr[y][i] == value){
                return false;
            }
        }
        // 사각형
        int start_x = (x / 3) * 3;
        int start_y = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int dx = start_x + i;
                int dy = start_y + j;
                if(arr[dy][dx] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void DFS(int y, int x) {
        if(x == 9) {
            DFS(y + 1, 0);
            return;
        }
        if(y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int temp = arr[i][j];
                    sb.append(temp).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(arr[y][x] == 0){
            for (int i = 1; i < 10; i++) {
                if(check(x, y, i)) {
                    arr[y][x] = i;
                    DFS(y, x + 1);
                }
            }
            arr[y][x] = 0;
            return;
        }
        DFS(y, x + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int len = 9;
        // y,x
        arr = new int[len][len];
        // 0인 값들을 담을 리스트

        for (int i = 0; i < len; i++) {  // y
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < len; j++) {   // x
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            }
        }

        DFS(0, 0);


        br.close();
    }

}
