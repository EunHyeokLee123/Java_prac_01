package CodeStudy.solution_2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int len;
    static int kind;
    static int window;
    static int coupon;
    static int[] arr;
    static int[] count;
    static int max = 0;

    static int getNextPlus(int now) {
        int result = now + window;
        if(result >= len) {
            result -= len;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st.nextToken());
        kind = Integer.parseInt(st.nextToken());
        window = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());
        arr = new int[len];
        count = new int[kind + 1];

        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 현재 범위에서 초밥의 종류
        int ct = 0;
        for(int i = 0; i < window; i++) {
            if(count[arr[i]] == 0) {
                ct++;
            }
            count[arr[i]]++;
        }
        max = ct;
        if(count[coupon] == 0) max++;
        int idx = 0;
        while(idx < len) {
            int nextIdx = getNextPlus(idx);
            // 일단 idx 꺼 빼기
            count[arr[idx]]--;
            if(count[arr[idx]] == 0) {
                ct--;
            }
            // nextIdx꺼 더하기
            count[arr[nextIdx]]++;
            if(count[arr[nextIdx]] == 1){
                ct++;
            }
            // 현재 범위에서의 초밥 종류의 개수
            int temp = ct;
            // 쿠폰 여부 확인
            if(count[coupon] == 0) temp++;
            max = Math.max(max, temp);
            idx++;
        }

        System.out.println(max);

        br.close();
    }

}
