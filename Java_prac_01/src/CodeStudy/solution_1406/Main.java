package CodeStudy.solution_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int idx = input.length();
        StringTokenizer st;
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("L")) {
                if(idx > 0) {
                    idx--;
                }
            }
            else if(command.equals("D")) {
                if(idx < input.length()) {
                    idx++;
                }
            }
            else if(command.equals("B")) {
                if(idx > 0) {
                    input.deleteCharAt(idx - 1);
                    idx--;
                }
            }
            // 문자 추가
            else {
                String newWord = st.nextToken();
                input.insert(idx, newWord);
                idx++;
            }
        }


        System.out.println(input);




        br.close();
    }

}
