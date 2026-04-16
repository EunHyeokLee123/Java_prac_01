package CodeStudy.solution_1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;
    static int MAX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for(int i = 0; i < N; i++) {
            double lm = Double.NEGATIVE_INFINITY;
            double rm = Double.NEGATIVE_INFINITY;
            int count = 0;

            for(int j = i - 1; j >= 0; j--) {
                double s = (double)(arr[j] - arr[i]) / (i - j);

                if(s > lm) {
                    lm = s;
                    count++;
                }
            }
            for(int j = i + 1; j < N; j++) {
                double s = (double)(arr[j] - arr[i]) / (j - i);

                if(s > rm) {
                    rm = s;
                    count++;
                }
            }

            MAX = Math.max(MAX, count);

        }


        System.out.println(MAX);
    }

}


