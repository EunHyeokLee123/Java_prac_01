package CodeStudy.solution_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> nega = new ArrayList<>();
    static List<Integer> posi = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static int mid = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 0보다 큰 수가 나왔는지
        // 0은 posi에 넣자
        boolean zero = false;
        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now >= 0) {
                zero = true;
            }
            if(zero) {
                posi.add(now);
            }
            else {
                nega.add(now);
            }
        }
        br.close();

        // 양수로만의 최소값 구하기
        if(posi.size() > 1) {
            int tp = posi.get(0) + posi.get(1);
            if(tp < mid) {
                mid = tp;
                result.add(posi.get(0));
                result.add(posi.get(1));
            }
        }
        // 음수로만의 최소값 구하기
        if(nega.size() > 1) {
            int tp = nega.get(nega.size() - 1) + nega.get(nega.size() - 2);
            if(Math.abs(tp) < mid) {
                mid = Math.abs(tp);
                result.clear();
                result.add(nega.get(nega.size() - 1));
                result.add(nega.get(nega.size() - 2));
            }
        }
        // 둘 다 있는 경우
        if(!nega.isEmpty() && !posi.isEmpty()) {
            int ne = nega.size() - 1;
            int po = 0;
            while(true) {
                int tp = posi.get(po) + nega.get(ne);
                if(tp == 0) {
                    result.clear();
                    result.add(posi.get(po));
                    result.add(nega.get(ne));
                    break;
                }
                if(Math.abs(tp) < mid) {
                    mid = Math.abs(tp);
                    result.clear();
                    result.add(posi.get(po));
                    result.add(nega.get(ne));
                }
                if(tp > 0) {
                    ne--;
                }
                else {
                    po++;
                }
                if(ne < 0 || po == posi.size()) {
                    break;
                }
            }
        }

        result.sort((a, b) -> a - b);

        System.out.println(result.get(0) + " " + result.get(1));
    }

}
