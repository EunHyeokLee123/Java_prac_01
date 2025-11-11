package CodeStudy.solution_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[length];
        result[0] = 0;
        int now = 0;
        int idx = now + 1;
        while(idx < length) {
            if(arr[now] >= arr[idx]) {
                result[idx] = now + 1;
                if(idx < length - 1) {
                    if (arr[idx] > arr[idx + 1]) {
                        now = idx;
                    }
                }
            }
            else {
                now = idx;
            }
            idx++;
        }

        String ans = "";
        for (int i : result) {
            ans += i + " ";
        }

        System.out.println(ans);

        br.close();
    }

}
