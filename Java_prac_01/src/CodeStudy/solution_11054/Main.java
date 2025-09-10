package CodeStudy.solution_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 커지는 것
        int[] upper = new int[length];
        // 작아지는 것
        int[] lower = new int[length];
        upper[0] = 1;
        lower[0] = 1;
        for (int i = 1; i < length; i++) {
            upper[i] = 1;
            lower[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    upper[i] = Math.max(upper[i], upper[j] + 1);
                }
                else if (arr[i] < arr[j]) {
                    lower[i] = Math.max(lower[i], lower[j] + 1);
                }
            }
        }
        int[] bitonic = new int[length];
        for (int i = 0; i < length; i++) {
            bitonic[i] = upper[i] + lower[i] - 1;
        }

        int max = 1;
        for (int i = 0; i < length; i++) {
            int temp = Math.max(upper[i], Math.max(lower[i], bitonic[i]));
            if(temp > max) {
                max = temp;
            }
        }

        System.out.println(max);

        br.close();
    }

}
