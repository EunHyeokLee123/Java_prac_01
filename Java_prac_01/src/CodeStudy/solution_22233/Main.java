package CodeStudy.solution_22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        // 1 아직 안나옴, 0 이미 나옴
        Map<String, Integer> word = new HashMap<>();
        for(int i = 0; i < N; i++) {
            word.put(br.readLine(), 1);
        }

        int count = N;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String now = st.nextToken();
                int flag = word.getOrDefault(now, -1);
                if(flag == 1) {
                    word.put(now, 0);
                    count--;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
