package CodeStudy.solution_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Bag {
        int weight;
        int value;
        public Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int max =  Integer.parseInt(st.nextToken());
        List<Bag> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(weight > max){
                continue;
            }
            list.add( new Bag(weight, value) );
        }
        // 오름차순 정렬
        list.sort((a, b) -> a.weight - b.weight);
        
        int[] dp = new int[max + 1];
        dp[0] = 0;
        for (int i = 0; i < list.size(); i++) {
            int now = list.get(i).weight;
            if(dp[now] == 0){
                dp[now] = list.get(i).value;
            }
            else {
                
            }
        }

        System.out.println(dp[max]);

        br.close();
    }

}
