package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class solution_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tar = br.readLine().toCharArray();
        char[] term = br.readLine().toCharArray();

        Queue<Character> ch = new ArrayDeque<>();
        for (int i = 0; i < tar.length; i++) {
            ch.offer(tar[i]);
        }
        for (int i = 0; i < term.length; i++) {

            if (!ch.isEmpty()) {
                if(ch.peek() == term[i]){
                    ch.poll();
                }
            }
            else{
                break;
            }
        }
        if(ch.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
