package CodeStudy.solution_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int revenue = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        long[] dp = new long[length + 1];
        if(length == 1) {
            System.out.println(1);
        }
        else if(length == 2) {
            System.out.println(2);
        }
        else {
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= length; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % revenue;
            }
            System.out.println(dp[length]);
        }
        br.close();
    }

}
