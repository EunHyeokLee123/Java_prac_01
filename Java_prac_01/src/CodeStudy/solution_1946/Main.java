package CodeStudy.solution_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

     static class Score {
        // 면접
        public int a;
        // 서류
        public int b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    public static int getCount(List<Score> people) {
        // a를 기준으로 오름차순 정렬  , s2, s1이면 내림차순
        people.sort(Comparator.comparingInt(s -> s.a));
        
        // 첫번째 사람은 무조건 합격
        int result = 1;
        // 첫번째사람의 b점수
        int target = people.get(0).b;
        for (int i = 1; i < people.size(); i++) {
            // 합격임
            if (people.get(i).b < target) {
                result++;
                target = people.get(i).b;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int casecount = Integer.parseInt(br.readLine());
        List<Score> people = new ArrayList<>();
        int[] result = new int[casecount];
        for (int i = 0; i < casecount; i++) {
            int total = Integer.parseInt(br.readLine());
            for (int j = 0; j < total; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Score score = new Score(a, b);
                people.add(score);
            }
            result[i] = getCount(people);
            people.clear();
        }

        for (int i : result) {
            System.out.println(i);
        }

        br.close();
    }

}
