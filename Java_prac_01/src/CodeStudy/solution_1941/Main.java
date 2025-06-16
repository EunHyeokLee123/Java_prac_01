package CodeStudy.solution_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int len = 5;
    static char[][] arr = new char[len][len];
    
    // 가로 5행에 대해서 S의 개수를 저장
    static int[] cols = new int[len];  // 가로
    
    // 세로 5열에 대한 S의 개수를 저장
    static int[] rows = new int[len];  // 세로

    // 모든 경우의 수를 저장할 변수
    static int result_count = 0;

    public static int isCanAlive(int x, int y) {
        int result = 0;
        // (가로, 세로) : (2, 5), (3, 4), (4, 3), (5, 2)
        // 가로의 길이
        for (int i = 2; i <= len; i++) {
            // 세로의 길이
            int dy = 7 - i + 1;
            for (int j = 0; j <= len - 2; j++) {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < len; i++) {   // y
            char[] temp = br.readLine().trim().toCharArray();
            int count = 0;
            for (int j = 0; j < len; j++) {   // x
                arr[i][j] = temp[j];
                if(temp[j] == 'S') {
                    count++;
                }
            }
            cols[i] = count;
        }

        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                char temp = arr[j][i];
                if(temp == 'S') {
                    count++;
                }
            }
            rows[i] = count;
        }

        // 무조건 가로, 세로 하나를 뽑았을 때, S의 개수가 최소한 4 이상이여야 함.
        // 가능한 길이의 경우  3 + 5,  4 + 4
        for (int i = 0; i < len; i++) {  // 가로
            for (int j = 0; j < len; j++) {  // 세로
                // 일단 가로세로 십자가 모양안에 S의 개수가 4개 이상인 것들에 대해서만 탐색을 진행하겠다.
                if(cols[i] + rows[j] >= 4) {
                    isCanAlive(i, j);
                }
            }
        }





        br.close();
    }

}
