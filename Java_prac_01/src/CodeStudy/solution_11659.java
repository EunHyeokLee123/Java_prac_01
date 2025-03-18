package CodeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        int size = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());


        // S[i] = S[i-1] + A[i]
        int[] sum = new int[size + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= size ; i++) {
            sum[i] = Integer.parseInt(st2.nextToken()) + sum[i-1];
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            int tmp = sum[Integer.parseInt(st3.nextToken())]
                    - sum[Integer.parseInt(st3.nextToken())-1];
            result.append(tmp).append("\n");
        }
        System.out.println(result);

    }
}
