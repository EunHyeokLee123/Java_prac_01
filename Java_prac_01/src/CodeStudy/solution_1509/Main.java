package CodeStudy.solution_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean isFal(String str, int start, int end){
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean[][] checked = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) {
            checked[i][i] = true;
        }
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if(isFal(input, i, j)) {
                    if(!checked[i][j]) {
                        checked[i][j] = true;
                    }
                }
            }
        }



        /*
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if(checked[i][j]){
                    for (int k = i; k <= j; k++) {
                        System.out.printf("%c", input.charAt(k));
                    }
                    System.out.println();
                }
            }
        }
        */

        br.close();
    }

}
