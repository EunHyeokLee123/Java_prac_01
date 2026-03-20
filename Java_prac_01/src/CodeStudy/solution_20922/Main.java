package CodeStudy.solution_20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[100001];
    static int[] arr;
    static int max;
    static int result = 1;

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
        visited[arr[left]] = 1;

        while(right < arr.length) {
           visited[arr[right]]++;
           // right의 숫자가 max개 이상 겹친 경우
           if(visited[arr[right]] > max) {
               int tar = arr[right];
               while(left <= right) {
                   if(arr[left] == tar) {
                       visited[arr[left]]--;
                       left++;
                       break;
                   }
                   visited[arr[left]]--;
                   left++;
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
