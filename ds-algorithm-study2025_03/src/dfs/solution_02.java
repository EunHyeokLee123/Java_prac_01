package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_02 {

    static Boolean[][] arr;
    static int len;
    static int edge;
    // 갈 수 있는지 여부
    static Boolean[] check;
    static int count = 0;

    public static void DFS(int num, String pa){
        if(num == 5){
            count++;
            System.out.println(pa + num);
        }
        else {
            check[num] = false;
            for (int i = 1; i <= len; i++) {
                if(arr[num][i] && check[i]){
                    DFS(i, pa + num + " ");
                }
            }
            // 백트래킴
            check[num] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st1.nextToken());
        edge = Integer.parseInt(st1.nextToken());
        arr = new Boolean[len+1][len+1];
        check = new Boolean[len+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                arr[i][j] = false;
            }
            check[i] = true;
        }
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
        }

        DFS(1,"");
        System.out.println(count);

        br.close();
    }

}
