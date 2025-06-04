package CodeStudy.solution_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public class Point{
        int x;
        int y;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    Queue<Point> queue = new LinkedList<Point>();

    public static void BFS() {

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] stairs = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int now = Integer.parseInt(br.readLine());
            stairs[i] = now;
        }

        int[] dp = new int[len + 1];

        if(len >= 1){
            dp[1] = stairs[1];
        }
        if(len >= 2){
            dp[2] = stairs[2] + stairs[1];
        }

        for (int i = 3; i <= len; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
        }

        System.out.println(dp[len]);



        br.close();
    }

}
