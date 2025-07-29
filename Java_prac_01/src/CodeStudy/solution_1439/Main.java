package CodeStudy.solution_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int one = 0;
        int zero = 0;

        if(input[0] == '0'){
            zero++;
        }
        else {
            one++;
        }

        for (int i = 1; i < input.length; i++) {
            if(input[i] != input[i - 1]){
                if(input[i] == '1'){
                    one++;
                }
                else {
                    zero++;
                }
            }
        }

        int result = Math.min(one, zero);

        System.out.println(result);

        br.close();
    }

}
