package CodeStudy.solution_1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int idx = 0;
        int base = 1;
        boolean flag = false;

        while(base <= 30000) {
            String now = String.valueOf(base);
            for(int i = 0; i < now.length(); i++) {
                if(now.charAt(i) == line.charAt(idx)) {
                    idx++;
                }
                if(idx == line.length()) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            base++;
        }

        System.out.println(base);

        br.close();
    }

}
