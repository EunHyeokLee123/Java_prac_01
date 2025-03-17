package queue.solution_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            deque.offer(i);
        }
        while(deque.size() != 1){
            deque.pop();
            int tmp = deque.pop();
            deque.offer(tmp);
        }
        System.out.println(deque.pop());


        br.close();
    }
}
