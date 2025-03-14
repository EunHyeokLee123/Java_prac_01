package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] it = new int[count];
        for (int i = 0; i < count; i++) {
            it[i] = Integer.parseInt(st.nextToken());
        }
        System.out.printf("%d ", it[0]);
        for (int i = 0; i < it.length - 1; i++) {
            if(it[i] < it[i+1])
                System.out.printf("%d ", it[i+1]);
        }



        br.close();
    }
}
