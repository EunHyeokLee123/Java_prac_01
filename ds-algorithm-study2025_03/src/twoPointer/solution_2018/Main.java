package twoPointer.solution_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tar = Integer.parseInt(br.readLine());
        int count = 1;
        int start = 1; int end = tar/2 + 1;
        while(start < end){
            int temp = 0;
            for (int i = start; i <= end; i++) {
                temp += i;
                if(temp == tar){
                    count++;
                    break;
                }
                else if(temp > tar){
                    break;
                }
            }
            start++;
        }
        System.out.println(count);





        br.close();
    }
}
