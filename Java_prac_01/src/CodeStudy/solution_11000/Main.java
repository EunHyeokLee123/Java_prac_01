package CodeStudy.solution_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Lesson {
        int start;
        int end;

        Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Lesson> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Lesson lesson = new Lesson(start, end);
            list.add(lesson);
        }

        // start를 기준으로 오름차순
        list.sort((a, b) -> a.start - b.start);

        // 우선순위 큐: 종료 시간이 빠른 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lesson lec : list) {
            if (!pq.isEmpty() && pq.peek() <= lec.start) {
                pq.poll(); // 같은 강의실 사용
            }
            pq.offer(lec.end); // 새로운 강의실 or 갱신
        }

        System.out.println(pq.size());

        br.close();
    }

}
