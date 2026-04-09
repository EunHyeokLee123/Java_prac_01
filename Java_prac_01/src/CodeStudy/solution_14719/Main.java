package CodeStudy.solution_14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int width;
    static int height;
    static int[] arr;
    static int tall = Integer.MIN_VALUE;

    static int getLeft(int cur) {
        int max = 0;
        for(int i = 0; i < cur; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int getRight(int cur) {
        int max = 0;
        for(int i = cur + 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        arr = new int[width];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < width; i++) {
            int tp = Integer.parseInt(st.nextToken());
            arr[i] = tp;
            if(tp > tall) {
                tall = i;
            }
        }
        br.close();
        int result = 0;
        for(int i = 0; i < width; i++) {
            int leftMax = getLeft(i);
            int rightMax = getRight(i);

            int min = Math.min(leftMax, rightMax);
            if(min > arr[i]) {
                result += (min - arr[i]);
            }
        }


        System.out.println(result);


    }

}
