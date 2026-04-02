package CodeStudy.solution_12919;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {

    static Set<String> set = new HashSet<>();

    static String first(String now) {
        if(now.charAt(now.length() - 1) == 'A') {
            return now.substring(0, now.length() - 1);
        }
        else {
            return null;
        }
    }

    static String second(String now) {
        StringBuilder sb = new StringBuilder(now);
        sb = sb.reverse();
        if(sb.charAt(sb.length() - 1) == 'B') {
            return sb.substring(0, sb.length() - 1);
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();
        br.close();

        boolean flag = false;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int u = 0; u < size; u++) {
                String cur = queue.poll();
                if(cur.equals(start)) {
                    flag = true;
                    break;
                }
                if(cur.length() > start.length()) {
                    String a1 = first(cur);
                    String a2 = second(cur);
                    if(a1 != null) {
                        queue.offer(a1);
                    }
                    if(a2 != null) {
                        queue.offer(a2);
                    }
                }
            }
        }
        int result = 0;
        if(flag) {
            result = 1;
        }

        System.out.println(result);

    }

}
