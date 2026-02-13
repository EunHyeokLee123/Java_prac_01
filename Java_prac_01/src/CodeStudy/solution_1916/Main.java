package CodeStudy.solution_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void DFS(int[][] arr, boolean[] visited,
                   int start, int target, int length, int now) {
        // target에 도착했다면
        if(start == target) {
            result = Math.min(now, result);
            return;
        }

        for (int i = 1; i <= length; i++) {
            // 방문하지 않은 점에 대해서
            if(!visited[i] && arr[start][i] > -1) {
                if(now + arr[start][i] > result) {
                    continue;
                }

                visited[i] = true;
                DFS(arr, visited, i, target, length, now + arr[start][i]);
                visited[i] = false;
            }
        }
    }

    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        // 없는 경로는 -1로 기재 -> 가중치 0이 존재하기 때문
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], -1);
        }
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start =  Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(arr[start][end] != -1) {
                if(arr[start][end] > weight) {
                    arr[start][end] = weight;
                }
            }
            else {
                arr[start][end] = weight;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        result = Integer.MAX_VALUE;
        DFS(arr, visited, start, target, N, 0);
        System.out.println(result);


        br.close();
    }

}
