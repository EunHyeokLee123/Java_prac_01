package CodeStudy.solution_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class newThink {

    static int[][] path;
    static int point;
    static int start;
    static boolean[] check;
    static Queue<Integer> Dre;

    public static void DFS(int now){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        point = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());
        start = Integer.parseInt(st1.nextToken());


        path = new int[point+1][point+1];
        check = new boolean[point+1];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            path[a1][a2] = 1;
            path[a2][a1] = 1;
        }



    }
}
