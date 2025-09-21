package CodeStudy.solution_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String target = br.readLine();
        int window = target.length();
        int idx = 0; int result = 0;
        while(idx + window <= origin.length()) {
            String now = origin.substring(idx, idx + window);
            if (now.equals(target)) {
                result++;
                idx += window;
            }
            else {
                idx++;
            }
        }
        System.out.println(result);

        br.close();
    }

}
