package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int tar = Integer.parseInt(st.nextToken());
        Queue<Integer> it = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            it.offer(i);
        }
        int count = 1;
        while(it.size() != 1){
            if(count != 3){
                int tmp = it.poll();
                it.offer(tmp);
                count++;
            }
            else{
                it.poll();
                count = 1;
            }
        }

        System.out.println(it.poll());

        br.close();
    }
}
