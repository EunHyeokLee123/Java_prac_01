package CodeStudy.solution_2133;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        // 길이가 홀수면 불가능

        if(len % 2 == 1){
            System.out.println(0);
        }
        else {

            // 길이가 짝수인 경우
            int[] dp = new int[31];

            dp[0] = 0;
            dp[2] = 3;
            dp[4] = 11;

            // https://january-diary.tistory.com/entry/BOJ-2133-%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0-JAVA

            for (int i = 6; i < 31; i += 2) {
                dp[i] = dp[i - 2] * 3 + 2;
                for (int j = i - 2; j >= 4; j-=2) {
                    dp[i] += dp[i - j] * 2;
                }
            }

            System.out.println(dp[len]);
        }


    }

}
