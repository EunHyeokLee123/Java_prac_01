package CodeStudy.solution_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int len;
    static int[][] arr;
    static boolean[] check;
    static int count = 0;

    public static void DFS(int tar){

        check[tar] = true;
        for (int i = 1; i <= num; i++) {
            int idx = arr[tar][i];
            if(idx == 1){
                if(!check[i]){
                    count++;
                    DFS(i);
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        len = Integer.parseInt(br.readLine());
        arr = new int[num + 1][num + 1];
        check = new boolean[num + 1];
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1; arr[e][s] = 1;
        }

        DFS(1);
        System.out.println(count);

        br.close();
    }
}
