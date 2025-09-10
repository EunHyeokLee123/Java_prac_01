package CodeStudy.solution_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class RGB {
        int red, green, blue;
        public RGB(int r, int g, int b) {
            red = r;
            green = g;
            blue = b;
        }
    }

    static void doNext(long[][] dp, RGB temp, int now, int idx) {
        // r
        if(idx == 0) {
            dp[now][0] = Math.min(dp[now - 1][1], dp[now - 1][2]) + temp.red;
        }
        // g
        else if (idx == 1) {
            dp[now][1] = Math.min(dp[now - 1][0], dp[now - 1][2]) + temp.green;
        }
        // b
        else {
            dp[now][2] = Math.min(dp[now - 1][0], dp[now - 1][1]) + temp.blue;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        RGB[] arr = new RGB[count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            RGB temp
                    = new RGB(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = temp;
        }
        long[][] dp = new long[count][3];
        // depth + r, g, b 순서
        dp[0][0] = arr[0].red;
        dp[0][1] = arr[0].green;
        dp[0][2] = arr[0].blue;
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                doNext(dp, arr[i], i, j);
            }
        }

        long result = Math.min(Math.min(dp[count - 1][0], dp[count - 1][1]), dp[count - 1][2]);
        System.out.println(result);


        br.close();
    }

}
