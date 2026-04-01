package CodeStudy.solution_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(queue.size() == N) {
                    int min = queue.poll();
                    if(now > min) {
                        queue.add(now);
                    }
                    else {
                        queue.add(min);
                    }
                }
                else {
                    queue.add(now);
                }
            }
        }

        System.out.println(queue.poll());

        br.close();
    }

}
