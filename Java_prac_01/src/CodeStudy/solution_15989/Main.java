package CodeStudy.solution_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int max = -1;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            if(temp > max) {
                max = temp;
            }
        }

        // 1이랑 2로만 이루어지는 경우를 dp에 저장해보자
        dp = new int[10001][4];

        /*
        1 - 1
        2 - 1+1, 2
        3 - 1+1+1, 2+1, 3
        4 - 1+1+1+1, 2+1+1, 2+2, 3+1
        5 - 1+1+1+1+1, 2+1+1+1, 2+2+1, 3+1+1, 3+2
        6 - 1+1+1+1+1+1, 2+1+1+1+1, 2+2+1+1, 2+2+2, 3+1+1+1, 3+2+1, 3+3
        7 - 1+1+1+1+1+1+1, 2+1+1+1+1+1, 2+2+1+1+1,
            2+2+2+1, 3+1+1+1+1, 3+2+1+1, 3+2+2, 3+3+1
        8 - 1+1+1+1+1+1+1+1, 2+1+1+1+1+1+1, 2+2+1+1+1+1,
            2+2+2+1+1, 2+2+2+2, 3+1+1+1+1+1, 3+2+1+1+1, 3+2+2+1, 3+3+1+1, 3+3+2


        */

        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int i = 4; i <= max; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3];
            sb.append(temp).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
