package CodeStudy.solution_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int S;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        result = n + 1;
        S = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int left = 0;
        int right = 0;
        int sum = arr[left];
        while(left < n) {
            if(sum >= S) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left];
                left++;
                if(right < left && right < n - 1) {
                    right++;
                    sum += arr[right];
                }
            }
            else {
                if(right < n - 1) {
                    right++;
                    sum += arr[right];
                }
                // right가 n-1까지 갔는데, sum이 S보다 작으면 탐색할 필요없음
                else {
                    break;
                }
            }
        }
        if(result == n + 1) {
            result = 0;
        }
        System.out.println(result);
    }

}
