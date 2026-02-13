package CodeStudy.solution_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Jim {
        int weigth;
        int value;
        Jim(int w, int v) {
            weigth = w;
            value = v;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int length = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        List<Jim> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Jim(w, v));
        }
        
        // 무게 기준 오름차순 정렬
        list.sort((a, b) -> a.weigth - b.weigth);
        
        int[] dp = new int[max + 1];
        if(max < list.get(0).weigth) {
            System.out.println(0);
        }
        else {
            int idx = 0;
            while(list.get(idx).weigth <= max && idx < length) {
                dp[list.get(idx).weigth] = list.get(idx).value;
                dp[list.get(idx).weigth]
                        = Math.max(dp[list.get(idx).weigth],
                        dp[max - list.get(idx).weigth] + list.get(idx).value);
                idx++;
            }
            System.out.println(dp[max]);
        }

        br.close();
    }

}
