package CodeStudy.solution_20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int max;

    // 사전순 배열 계산기
    static boolean isFront(String a1, String a2) {

        // 이미 2번 조건을 통해 길이는 같은 상태에서만 비교가 이루어짐.
        for(int i = 0; i < a1.length(); i++) {
            int temp = a1.charAt(i) - a2.charAt(i);
            if(temp > 0) {
                // false면 a2가 더 사전순 앞임
                return false;
            }
            else if(temp < 0) {
                // true면 a1이 더 사전순 앞임
                return true;
            }
        }
        // 완전히 같은 문자
        // 이건 나올 수 없음.
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            if(input.length() >= max) {
                if(!map.containsKey(input)) {
                    map.put(input, 0);
                    result.add(input);
                }
                map.put(input, map.get(input) + 1);
            }
        }

        result.sort((a, b) -> {
            if(map.get(a) == map.get(b)) {
                if(a.length() == b.length()) {
                    return isFront(a, b) ? -1 : 1;
                }
                return b.length() - a.length();
            }
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size() - 1; i++) {
            sb.append(result.get(i)).append("\n");
        }
        sb.append(result.get(result.size() - 1));

        System.out.println(sb);

        br.close();
    }

}
