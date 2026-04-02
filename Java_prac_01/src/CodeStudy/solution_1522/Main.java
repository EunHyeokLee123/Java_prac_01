package CodeStudy.solution_1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int a = 0;
    static int N;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        N = line.length();
        for(int i = 0; i < N; i++) {
            if(line.charAt(i) == 'a') {
                a++;
            }
        }

        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < a; j++) {
                int idx = i + j;
                if(idx >= N) {
                    idx -= N;
                }
                if(line.charAt(idx) == 'b') {
                    count++;
                }
            }
            if(count < result) {
                result = count;
            }
        }

        System.out.println(result);


        br.close();
    }

}
