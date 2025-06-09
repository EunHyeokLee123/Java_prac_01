package CodeStudy.solution_1720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        // 전체 경우
        int[] dp1 = new int[31];

        // 펠린드롬의 경우, 좌우대칭
        int[] dp2 = new int[31];

        dp1[0] = 0; dp1[1] = 1; dp1[2] = 3; dp1[3] = 5;

        dp2[0] = 1; dp2[1] = 1; dp2[2] = 3; dp2[3] = 1;

        for (int i = 4; i <= len; i++) {
            dp1[i] = dp1[i - 1] + (dp1[i-2] * 2);
            dp2[i] = dp2[i - 2] + (dp2[i - 4] * 2);
        }

        int result = (dp1[len] - dp2[len])/2 + dp2[len];

        System.out.println(result);
        br.close();
    }

}
