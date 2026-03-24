package CodeStudy.solution_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visited;
    static Info[] info;
    static int[] result;

    static class Info {
        int w;
        int h;
        Info(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        info = new Info[N];
        result = new int[N];
        for(int i = 0; i < N; i++) {
            String[] tp = br.readLine().split(" ");
            info[i] = new Info(Integer.parseInt(tp[0]), Integer.parseInt(tp[1]));
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j && (!visited[i][j] || !visited[j][i])) {
                    // i가 j를 이김
                    if(info[i].w > info[j].w && info[i].h > info[j].h) {
                        result[j]++;
                    }
                    // j가 i를 이김
                    if(info[i].w < info[j].w && info[i].h < info[j].h) {
                        result[i]++;
                    }
                    // 해당 대결은 탐색 완료 처리
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N - 1; i++) {
            sb.append(result[i] + 1).append(" ");
        }
        sb.append(result[N - 1] + 1);

        System.out.println(sb);

        br.close();
    }

}
