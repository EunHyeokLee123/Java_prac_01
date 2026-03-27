package CodeStudy.solution_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        char[] line = br.readLine().toCharArray();
        // 0은 햄버거가 있음
        // 1은 햄버거가 먹힘
        // 2는 사람이 있음
        int[] ate = new int[N];

        int result = 0;
        int idx = 0;
        while(idx < N) {
            if(line[idx] == 'P') {
                ate[idx] = 2;
                for(int i = idx - range; i <= idx + range; i++) {
                    if(i >= 0 && i < N) {
                        if(line[i] == 'H' && ate[i] == 0) {
                            result++;
                            ate[i] = 1;
                            break;
                        }
                    }
                }
            }
            idx++;
        }

        System.out.println(result);

        br.close();
    }

}
