package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_01 {

    static int len;
    static int[] check;

    public static void DFS(int num){
        // 배열 끝까지 탐색이 완려된 경우
        if(num == len + 1){
            StringBuilder st = new StringBuilder();
            for (int i = 1; i <= len ; i++) {
                if(check[i] == 1){
                    st.append(i).append(" ");
                }
            }
            // 공집합은 출력 제외
            if(!st.isEmpty())
                System.out.println(st);
        }
        else {

            check[num] = 1;
            DFS(num + 1); // left

            check[num] = 0;
            DFS(num + 1); // right
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        check = new int[len + 1];
        DFS(1);
        br.close();
    }
}
