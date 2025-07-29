package CodeStudy.solution_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Lesson {
        int start;
        int end;
        boolean held;

        Lesson(int start, int end) {
            this.start = start;
            this.end = end;
            this.held = false;
        }
    }

    static int isEnd(List<Lesson> list) {
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).held) {
                return i;
            }
        }
        return -1;
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

        // start를 기준으로 오름차순 -> 같다면 end를 기준으로
        list.sort((a, b) -> {
            if(a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        int count = 0;

        while(true) {
            int start = isEnd(list);
            if(start == -1) {
                break;
            }
            list.get(start).held = true;
            int time = list.get(start).end;
            for (int i = start + 1; i < list.size(); i++) {
                if(list.get(i).start >= time && !list.get(i).held) {
                    time = list.get(i).end;
                    list.get(i).held = true;
                }
            }
            count++;
        }

        System.out.println(count);

        br.close();
    }

}
