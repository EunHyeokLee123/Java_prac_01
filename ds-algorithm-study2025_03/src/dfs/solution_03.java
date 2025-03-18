package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_03 {

    static int len;
    static int[] arr;
    static boolean[] check;
    static boolean result = false;


    public static void DFS(int idx){
        if(idx == len){
            int s1 = 0, s2 = 0;
            for (int i = 0; i < len; i++) {
                if(check[i]){
                    s1 += arr[i];
                }
                else{
                    s2 += arr[i];
                }
            }
            if(s1 == s2){
                result = true;
            }
        }
        else {
            // idx를 가지는 경우
            check[idx] = false;
            DFS(idx + 1);

            check[idx] = true;
            // idx를 가지지 않는 경우
            DFS(idx + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[len];
        check = new boolean[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[i] = true;
        }
        DFS(0);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");



        br.close();
    }

}
