package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st1.nextToken());
        int tar = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int a1 = 0; int max = 0;
        while(a1 <= len - tar){
            int temp = arr[a1] + arr[a1+1] + arr[a1+2];
            if(temp > max)
                max = temp;
            a1++;
        }
        System.out.println(max);


        br.close();
    }

}
