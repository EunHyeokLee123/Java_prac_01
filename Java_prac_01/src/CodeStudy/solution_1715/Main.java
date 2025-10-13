package CodeStudy.solution_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        // 우선순위큐에 대해서 꼭 인지를 하고 있자!
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        if(length == 1) {
            System.out.println(0);
        }
        else {
            int result = 0;
            while(pq.size() > 1) {
                int temp = pq.poll() + pq.poll();
                pq.offer(temp);
                result += temp;
            }
            System.out.println(result);
        }

        br.close();
    }

}
