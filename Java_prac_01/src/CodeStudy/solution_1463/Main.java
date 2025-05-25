package CodeStudy.solution_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        arr[2] = 1; arr[3] = 1;
        for (int i = 4; i <= N; i++) {
            if(i % 6 == 0){
                arr[i] = Math.min(arr[i / 3], Math.min(arr[i / 2], arr[i - 1])) + 1;
            }
            else if(i % 3 == 0){
                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
            }
            else if(i % 2 == 0){
                arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
            }
            else{
                arr[i] = arr[i - 1] + 1;
            }
        }
        System.out.println(arr[N]);

        br.close();
    }

}
