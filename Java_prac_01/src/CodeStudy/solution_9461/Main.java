package CodeStudy.solution_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        long[] arr = new long[101];
        arr[0] = -1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;

        for (int i = 7; i < 101; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }

        for (int i : result) {
            System.out.println(arr[i]);
        }

        br.close();
    }

}
