package CodeStudy.solution_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static long calProfit(int len, int[] arr) {

        long profit = 0;
        int max_price = arr[len - 1];
        int idx = len - 2;
        while(idx >= 0) {
            if(arr[idx] < max_price) {
                profit += max_price - arr[idx];
            }
            else{
                max_price = arr[idx];
            }
            idx--;
        }
        return profit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < totalCase; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = calProfit(len, arr);
            list.add(result);
        }
        for (Long i : list) {
            System.out.println(i);
        }
        br.close();
    }

}
