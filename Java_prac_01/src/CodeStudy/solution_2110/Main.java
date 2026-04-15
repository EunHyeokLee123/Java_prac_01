package CodeStudy.solution_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int len;
    static int N;
    static int[] arr;

    static boolean canDo(int gap) {
        int count = 1;
        int idx = 0;
        for(int i = 1; i < len; i++) {
            if(arr[i] - arr[idx] >= gap) {
                count++;
                idx = i;
            }
        }

        if(count >= N) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(arr);
        int low = 1;
        int high = arr[len - 1] - arr[0];


        int mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;

            if(canDo(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(high);

    }

}
