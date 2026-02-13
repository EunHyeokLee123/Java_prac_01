package CodeStudy.solution_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int length = 5;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // y x
        char[][] arr = new char[length + 1][length + 1];
        for (int i = 1; i < length + 1; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < length; j++) {
                arr[i][j + 1] = temp[j];
            }
        }
        





        br.close();
    }

}
