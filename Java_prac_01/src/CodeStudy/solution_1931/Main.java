package CodeStudy.solution_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Meet {
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Meet> list = new ArrayList<>();

        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meet(start, end));
        }
        
        // end를 기준으로 오름차순 정렬
        list.sort((a, b) -> {
            // end가 같은 경우에는 start를 기준으로 오름차순 정렬
            if(a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        int sum = 1;
        // 첫번째는 무조건 들어가짐. end가 가장 빠르니까
        int time = list.get(0).end;
        int idx = 1;
        while(idx < length) {
            // 회의가 시작이 가능한 경우
            if(list.get(idx).start >= time) {
                sum++;
                time = list.get(idx).end;
            }
            idx++;
        }


        System.out.println(sum);

        br.close();
    }

}
