package CodeStudy.solution_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        // 정답을 저장할 리스트
        List<Integer> result = new ArrayList<Integer>();
        // 1부터 length까지의 정수를 저장할 큐
        Queue<Integer> queue = new ArrayDeque<>();
        // 1부터 숫자를 저장하기
        for (int i = 1; i <= length; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            // tar - 1 회를 poll 후 다시 맨뒤로 offer
            for (int i = 1; i < target; i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }
            // tar번째를 뽑아서 result에 저장
            result.add(queue.poll());
        }

        System.out.printf("<");
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.printf("%d, ", result.get(i));
        }
        System.out.printf("%d>", result.get(result.size() - 1));

        br.close();
    }

}
