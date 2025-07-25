package CodeStudy.solution_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[length];
        // 오름차순 정렬 -> 짧게 걸리는 사람부터 수행하게끔
        list.sort((a,b) -> a - b);

        result[0] = list.get(0);
        if(length > 1) {
            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] + list.get(i);
            }
        }

        long last = 0L;
        for (int i = 0; i < length; i++) {
            last += result[i];
        }

        System.out.println(last);

        br.close();
    }

}
