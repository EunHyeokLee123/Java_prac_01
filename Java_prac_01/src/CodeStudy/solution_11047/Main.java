package CodeStudy.solution_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st1.nextToken());
        int target = Integer.parseInt(st1.nextToken());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int min = 0;
        int idx = len - 1;
        while(idx >= 0) {
            // 금액이 0인 경우
            if(target == 0) {
                break;
            }
            // 단위 금액이 타겟 금액보다 큰 경우
            if(arr[idx] > target) {
                idx--;
            }
            // 작은 경우
            else {
                // 뺄 수 있는 만큼 계속 빼기
                while(target >= arr[idx]) {
                    target -= arr[idx];
                    min++;
                }
                idx--;
            }
        }

        System.out.println(min);

        br.close();
    }

}
