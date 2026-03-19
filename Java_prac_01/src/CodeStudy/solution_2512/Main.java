package CodeStudy.solution_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static int len;
    static long budget;

    static boolean canDo(int term) {
        long total = 0;
        for(int i = 0; i < len; i++) {
            total += Math.min(arr[i], term);
            if(total > budget) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[len];
        int min = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            max = Math.max(max, temp);
        }
        budget = Integer.parseInt(br.readLine());

        int answer = 0;
        while(min <= max) {
            int mid = (max + min) / 2;
            if(canDo(mid)) {
                answer = mid;
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }


        System.out.println(answer);

        br.close();
    }

}
