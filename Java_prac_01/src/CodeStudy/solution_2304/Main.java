package CodeStudy.solution_2304;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[1001];
    static int[] left = new int[1001];
    static int[] right = new int[1001];
    static int start;
    static int end;
    static long result = Long.MAX_VALUE;

    static void getArea(int idx) {
        long sum = 0;
        int max = 0;
        for(int i = start; i < idx; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += max;
        }

        max = 0;
        for(int i = end; i > idx; i--) {
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += max;
        }

        sum += arr[idx];

        if(sum < result) {
            result = sum;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        start = Integer.MAX_VALUE;
        end = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x > end) {
                end = x;
            }
            if(x < start) {
                start = x;
            }
            arr[x] = y;
        }

        int temp = start;
        left[start] = start;
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] >= arr[temp]) {
                temp = i;
            }
            left[i] = temp;
        }
        temp = end;
        right[end] = end;
        for(int i = end - 1; i >= start; i--) {
            if(arr[i] >= arr[temp]) {
                temp = i;
            }
            right[i] = temp;
        }

        for(int i = start; i <= end; i++) {
            if(left[i] == right[i]) {
                getArea(i);
            }
        }

        System.out.println(result);

        br.close();
    }

}
