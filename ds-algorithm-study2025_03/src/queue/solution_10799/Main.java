package queue.solution_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Queue<Character> ch = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            ch.offer(arr[i]);
        }
        int count = 0;
        int stick = 0;
        boolean laserOn = false;
        for (int i = 0; i < arr.length; i++) {
            char tar = ch.poll();
            if(tar == '('){
                stick++;
                laserOn = true;
            }
            else{
                if(laserOn){
                    stick--;
                    count += stick;
                    laserOn = false;
                }
                else{
                    count++;
                    stick--;
                }
            }
        }
        System.out.println(count);




        br.close();
    }
}
