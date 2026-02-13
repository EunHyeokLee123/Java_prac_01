package CodeStudy.solution_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Con {
        int start;
        int end;
        int value;
        public Con(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Con> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            // 1일에 시작해서 1일 걸리면 2일부터는 새 작업이 가능함.
            Con temp = new Con(i, i + end - 1, value);
            list.add(temp);
        }

        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 0; i < list.size(); i++) {
            Con temp = list.get(i);
            // n일까지 끝나야 함.
            if(temp.end < n + 1) {
                for(int j = 0; j < temp.start; j++) {
                    dp[temp.end] = Math.max(dp[temp.end], dp[j] + temp.value);
                }
            }
        }

        int ans = -1;
        for(int a : dp) {
            ans = Math.max(ans, a);
        }

        System.out.println(ans);

        br.close();

    }

}
