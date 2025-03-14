package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution3 {

    static String GBB(int a1, int a2){
        return switch (a1 - a2) {
            case 0 -> "D";
            case 1, -2 -> "A";
            case -1, 2 -> "B";
            default -> null;
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[count];
        for (int i = 0; i < count; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] B = new int[count];
        for (int i = 0; i < count; i++) {
            B[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < count; i++) {
            System.out.println(GBB(A[i], B[i]));
        }
        br.close();
    }
}
