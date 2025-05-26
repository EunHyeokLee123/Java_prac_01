package CodeStudy.solution_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean[][] checked = new boolean[input.length() + 1][input.length() + 1];

        // 모든 팰린드롬 구하기
        for (int i = 1; i <= input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                boolean flag = true;
                int s = i - 1; int e = j - 1;
                while(s <= e){
                    if(input.charAt(s) != input.charAt(e)){
                        flag = false;
                        break;
                    }
                    s++; e--;
                }
                if(flag){
                    checked[i][j] = true;
                }
            }
        }
        int[] dp = new int[input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            dp[i] = input.length();
        }
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if(checked[j][i]){
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        System.out.println(dp[input.length()]);
/*
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if(checked[i][j]){
                    for (int k = i; k <= j; k++) {
                        System.out.printf("%c", input.charAt(k));
                    }
                    System.out.println();
                }
            }
        }
      */
        br.close();
    }

}
