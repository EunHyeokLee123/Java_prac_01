package CodeStudy.solution_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int REVENUE = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] dp = new int[length + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        if(length == 1) {
            System.out.println(9);
        }
        else {
            for (int i = 2; i <= length; i++) {
                dp[i][0] = dp[i - 1][1] % REVENUE;
                dp[i][9] = dp[i - 1][8] % REVENUE;
                for (int j = 1; j < 9; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % REVENUE;
                }
            }
            long result = 0;
            for (int i = 0; i < 10; i++) {
                result += dp[length][i] % REVENUE;
            }
            System.out.println(result % REVENUE);
        }
        br.close();

    }

}
