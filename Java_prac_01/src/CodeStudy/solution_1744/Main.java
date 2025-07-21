package CodeStudy.solution_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        boolean zero = false;
        for (int i = 0; i < len; i++) {
            int tar = Integer.parseInt(br.readLine());
            if (tar < 0) {
                negative.add(tar);
            }
            else if ( tar == 0) {
                zero = true;
            }
            else {
                positive.add(tar);
            }
        }

        long result = 0L;
        Collections.sort(negative);
        Collections.sort(positive);

        while(negative.size() > 1) {
            // 맨 앞 2개 찾기
            int n1 = negative.get(0);
            int n2 = negative.get(1);

            result += n1 * n2;
            // 맨앞 2개  삭제
            negative.remove(0);
            negative.remove(0);
        }

        while(positive.size() > 1) {
            // 맨 뒤 2개 찾기
            int p1 = positive.get(positive.size()-1);
            int p2 = positive.get(positive.size()-2);
            if(p2 != 1) {
                result += p1 * p2;
            }
            else {
                result += (p1 + p2);
            }
            // 맨 뒤 2개 삭제
            positive.remove(positive.size()-1);
            positive.remove(positive.size()-1);
        }

        // 음수가 한 개 남은 경우
        if(!negative.isEmpty()) {
            // 0이 있다면
            if(zero) {
                // 남은 음수 하나 삭제
                negative.remove(0);
            }
            // 0이 없다면
            else {
                // 양수가 1개 남았다면
                if(!positive.isEmpty()) {
                    int lastPositive = positive.get(0);
                    int lastNegative = negative.get(0);
                    result += (lastNegative + lastPositive);
                    positive.remove(0);
                    negative.remove(0);
                }
                // 남은 양수가 없다면
                else {
                    result += negative.get(0);
                    negative.remove(0);
                }
            }
        }

        // 음수가 안 남은 경우
        // 만약 양수가 남았다면
        if(!positive.isEmpty()) {
            result += positive.get(0);
            positive.remove(0);
        }

        System.out.println(result);

        br.close();
    }

}
