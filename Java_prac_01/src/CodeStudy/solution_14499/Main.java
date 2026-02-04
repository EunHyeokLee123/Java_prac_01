package CodeStudy.solution_14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 세로
        int m = Integer.parseInt(st.nextToken());
        // 가로
        int n = Integer.parseInt(st.nextToken());
        // 현 위치
        int nx = Integer.parseInt(st.nextToken());
        int ny = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] oper = new int[count];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < count; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        // 주사위 값 정보 -> 0은 쓰지말자
        // 1 - 6, 3 - 4, 2 - 5 가 맞은 편
        int[] dice = new int[7];


        br.close();
    }

}
