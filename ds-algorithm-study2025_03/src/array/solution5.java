package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = Integer.parseInt(br.readLine());
        int[][] it = new int[idx][idx];
        for (int i = 0; i < idx; i++) {
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            for (int j = 0; j < idx; j++) {
                it[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        // 대각선 먼저, 주대각성분의 합
        for (int k = 0; k < idx; k++) {
            max += it[k][k];
        }

        int temp = 0;
        // 반대 대각선의 합
        for (int k = 0; k < idx; k++) {
            temp += it[4-k][k];
        }
        // 최대값 최신화
        if(max < temp)
            max = temp;
        // 가로, 세로 값 구해서 최대값 최신화
        for (int i = 0; i < idx; i++) {
            int s1 = 0; // 가로
            int s2 = 0; // 세로
            for (int j = 0; j < idx; j++) {
                s1 += it[i][j];
                s2 += it[j][i];
            }
            if(s1 > s2){
                if(max < s1)
                    max = s1;
            }
            else{
                if(max < s2)
                    max = s2;
            }
        }

        System.out.println(max);
        br.close();
    }
}
