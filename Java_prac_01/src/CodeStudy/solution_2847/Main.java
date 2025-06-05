package CodeStudy.solution_2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        int tar = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int temp = arr[i];
            if(temp >= tar){
                int left = temp - tar;
                count = count + left + 1;
                arr[i] = temp - (left + 1);
            }
            tar = arr[i];
        }

        System.out.println(count);

        br.close();
    }

}
