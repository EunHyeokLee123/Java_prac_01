package CodeStudy.solution_2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int start;
        int end;

        Point(int x, int y) {
            this.start = x;
            this.end = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        
        // start를 기준으로 오름차순
        list.sort((a, b) -> {
            return a.start - b.start;
        });

        List<Integer> result = new ArrayList<>();
        // 시작점
        int idx = 1;
        int start = list.get(0).start;
        int now = list.get(0).end;
        if(length == 1) {
            result.add(now - start);
        }
        while(true) {
            if(idx == list.size()) {
                break;
            }
            // 이어지지 않는 경우
            if(now < list.get(idx).start) {
                result.add(now - start);
                // 더이상 아이템이 없는 경우
                if(idx == length - 1) {
                    // 마지막 길이 더함
                    result.add(list.get(idx).end - list.get(idx).start);
                    break;
                }
                // 아이템이 남은 경우
                // 길이 갱신 -> 새로운 시작
                start = list.get(idx).start;
                now = list.get(idx).end;
            }
            // 이어지는 경우
            else {
                // 끝점이 갱신되는 경우
                if(now < list.get(idx).end) {
                    now = list.get(idx).end;
                }
                // 더이상 아이템이 없는 경우
                if(idx == length - 1) {
                    result.add(now - start);
                }
            }
            idx++;
        }

        int total = 0;
        for (Integer i : result) {
            total += i;
        }

        System.out.println(total);

        br.close();
    }

}
