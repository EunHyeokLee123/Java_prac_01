package CodeStudy.solution_2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬
        list.sort((a, b) -> a - b);

        long max = Long.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            Long temp = (long) (list.get(i) * (length - i));
            if(temp > max) {
                max = temp;
            }
        }

        System.out.println(max);

        br.close();
    }

}
