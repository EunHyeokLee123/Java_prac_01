package CodeStudy.solution_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long Twice(long input) {
        return input * 2;
    }

    static long Ten(long input) {
        return input * 10 + 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int dest =  Integer.parseInt(st.nextToken());

        int count = 0;
        Queue<Long> queue = new ArrayDeque<>();
        queue.offer((long) start);
        boolean can = false;
        boolean[] visited = new boolean[dest + 1];
        visited[start] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long curr = queue.poll();
                //System.out.println(curr);
                //visited[curr] = true;
                if(curr == dest) {
                    count++;
                    can = true;
                }
                long one = Twice(curr);
                long two = Ten(curr);
                if(one > 0 && one <= dest && !visited[Math.toIntExact(one)]) {
                    queue.offer(one);
                    visited[Math.toIntExact(one)] = true;
                }
                if(two > 0 && two <= dest && !visited[Math.toIntExact(two)]) {
                    queue.offer(two);
                    visited[Math.toIntExact(two)] = true;
                }
            }
            //System.out.println();
            if(can) {
                break;
            }
            count++;
        }

        if(can) {
            System.out.println(count);
        }
        else {
            System.out.println(-1);
        }

        br.close();
    }

}

