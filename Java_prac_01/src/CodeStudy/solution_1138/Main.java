package CodeStudy.solution_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            int count = 0;
            for(int j = 1; j <= N; j++) {
                if(result[j] == 0) {
                    count++;
                }
                if(count == now + 1) {
                    result[j] = i;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N; i++) {
            sb.append(result[i] + " ");
        }

        sb.append(result[N]);

        System.out.println(sb);

        br.close();
    }

}
