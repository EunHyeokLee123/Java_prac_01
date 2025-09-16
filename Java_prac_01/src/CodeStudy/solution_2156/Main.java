package CodeStudy.solution_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length + 1];
        arr[0] = 0;
        for (int i = 1; i <= length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(length == 1) {
            System.out.println(arr[1]);
        }
        else if (length == 2) {
            System.out.println(arr[1] + arr[2]);
        }
        // 길이가 3이상
        else {
            int[] dp = new int[length + 1];
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= length; i++) {
                int temp1 = dp[i - 3] + arr[i - 1] + arr[i];
                int temp2 = dp[i - 2] + arr[i];
                int temp3 = dp[i - 1];
                dp[i] = Math.max(temp1, Math.max(temp2, temp3));
            }
            System.out.println(dp[length]);
        }
        br.close();
    }

}
