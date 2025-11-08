package CodeStudy.solution_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.add(temp);
            }
        }

        br.close();
    }

}
