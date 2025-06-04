package CodeStudy.solution_14469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static class cow {
        int start_time;
        int check_time;

        public cow(int start_time, int check_time) {
            this.start_time = start_time;
            this.check_time = check_time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        ArrayList<cow> cowList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cow temp = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            cowList.add(temp);
        }

        List<cow> sortCowList = cowList.stream().sorted(Comparator.comparing(cow -> cow.start_time))
                .collect(Collectors.toList());


        int totalTime = 0;
        for (int i = 0; i < count; i++) {
            cow temp = sortCowList.get(i);
            // 현재 시각보다 다음 검사 시작 시각이 큰 경우
            if(temp.start_time > totalTime){
                totalTime = temp.start_time;
            }
            totalTime += temp.check_time;
        }

        System.out.println(totalTime);

        br.close();
    }

}
