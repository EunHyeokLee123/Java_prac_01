package CodeStudy.solution_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int tar = Integer.parseInt(br.readLine());
        int count = 0;
        int s = 0; int e = len - 1;
        while(s < e){
            int tmp = arr[s] + arr[e];
            if(tmp < tar){
                s++;
            }
            else if(tmp == tar){
                count++;
                s++; e--;
            }
            else{
                e--;
            }
        }
        System.out.println(count);


        br.readLine();
    }
}
