package CodeStudy.solution_1026;

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
        List<Integer> a1 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(i == 0) {
                for (int j = 0; j < length; j++) {
                    a1.add(Integer.parseInt(st.nextToken()));
                }
            }
            else{
                for (int j = 0; j < length; j++) {
                    b1.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        
        // a는 오름 차순 -> 내림차순은 b - a
        a1.sort((a, b) -> a - b);
        b1.sort((a, b) -> b - a);

        long result = 0L;
        for (int i = 0; i < length; i++) {
            result += a1.get(i) * b1.get(i);
        }


        System.out.println(result);

        br.close();
    }

}
