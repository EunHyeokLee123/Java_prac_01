package CodeStudy.solution_20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[100001];
    static int[] arr;
    static int max;
    static int result = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[Integer.parseInt(st.nextToken())];
        // 겹치는 원소 제한
        max = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = left + 1;
        visited[left] = 1;

        while(right < arr.length) {
            // 겹치지 않는 경우
            if(visited[arr[right]] == 0) {
                visited[arr[right]]++;
            }
            // 겹치는 경우
            else {
                // 기존에 겹치던 얘들이랑 겹친 경우
                // 문제 없음
                if(visited[arr[right]] > 1) {
                    visited[arr[right]]++;
                }
                // 새롭게 겹치는 얘들이 생긴 경우
                else {
                    visited[arr[right]]++;
                    count++;
                    // 개수 제한을 넘어가는 경우
                    // left를 키워야 함.
                    while(count > max && left <= right) {
                        visited[arr[left]]--;
                        if(visited[arr[left]] == 1) {
                            count--;
                        }
                        left++;
                    }
                }
            }
            if(right - left + 1 > result) {
                result = right - left + 1;
            }
            right++;
        }

        System.out.println(result);

        br.close();
    }

}
