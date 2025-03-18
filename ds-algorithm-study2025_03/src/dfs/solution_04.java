package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_04 {

    static int total;
    static int len;
    static int[] arr;
    static int max = 0;
    static int tmp = 0;

    public static void DFS(int idx){
        if(idx == len){
            return;
        }
        else{
            tmp += arr[idx];
            if(tmp < total){
                if(tmp > max){
                    max = tmp;
                }
                DFS(idx + 1);
            }
            tmp -= arr[idx];

            DFS(idx+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        total = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        DFS(0);
        System.out.println(max);
        br.close();
    }
}
