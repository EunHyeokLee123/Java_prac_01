package CodeStudy.solution_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int tar = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        int start = 0, end = len - 1, total = 0;
        while(start < end){
            total = arr[start] + arr[end];
            if(total < tar){
                start++;
            }else if(total == tar){
                count++; start++; end--;
            }
            else{
                end--;
            }
        }
        System.out.println(count);

        br.close();
    }
}
