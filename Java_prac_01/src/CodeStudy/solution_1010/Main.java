package CodeStudy.solution_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }

    static long permutation(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }

    static long choiceCalculator(int r, int n) {

        if(r > n / 2) {
            r = n - r;
        }
        return permutation(n, r)/factorial(r);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        long[] result = new long[length];
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            result[i] = choiceCalculator(left, right);
        }

        for (long l : result) {
            System.out.println(l);
        }

        br.close();
    }

}
