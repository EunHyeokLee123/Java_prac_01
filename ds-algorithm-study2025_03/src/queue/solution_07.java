package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class solution_07 {

    static class Patient{
        int idx;
        int prior;

        public Patient(int idx, int prior) {
            this.idx = idx;
            this.prior = prior;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st1.nextToken());
        int tar = Integer.parseInt(st1.nextToken());
        int[] pati = new int[len];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            pati[i] = Integer.parseInt(st2.nextToken());
        }
        ArrayDeque<Patient> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if(deque.isEmpty())
                deque.push(new Patient(i,pati[i]));
            else if(pati[i] > deque.peek().prior){
                deque.push(new Patient(i,pati[i]));
            }
            else{
                deque.offer(new Patient(i,pati[i]));
            }
        }
        int i = -3;
        int count = 0;
        while(i != tar){
            Patient temp = deque.pop();
            i = temp.idx;
            count++;
        }
        System.out.println(count);

        br.close();
    }
}
