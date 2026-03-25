package CodeStudy.solution_9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 팀의 참가자 수를 저장할 map
            Map<Integer, Integer> map = new HashMap<>();
            int[] temp = new int[len];
            for(int u = 0; u < len; u++) {
                int num = Integer.parseInt(st.nextToken());
                temp[u] = num;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Map<Integer, List<Integer>> score = new HashMap<>();
            int idx = 1;
            for(int k = 0; k < len; k++) {
                if(map.get(temp[k]) >= 6) {
                    if(!score.containsKey(temp[k])) {
                        score.put(temp[k], new ArrayList<>());
                    }
                    score.get(temp[k]).add(idx);
                    idx++;
                }
            }

            int[] result = new int[3];
            for(Integer key : score.keySet()) {
                int sum = 0;
                for(int j = 0; j < 4; j++) {
                    sum += score.get(key).get(j);
                }
                int five = score.get(key).get(4);
                // 첫 점수 계산 인 경우
                if(result[0] == 0) {
                    result[0] = key;
                    result[1] = sum;
                    result[2] = five;
                }
                else {
                    if(result[1] > sum) {
                        result[0] = key;
                        result[1] = sum;
                        result[2] = five;
                    }
                    else if(result[1] == sum) {
                        if(result[2] > five) {
                            result[0] = key;
                            result[2] = five;
                        }
                    }
                }
            }
            sb.append(result[0]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
