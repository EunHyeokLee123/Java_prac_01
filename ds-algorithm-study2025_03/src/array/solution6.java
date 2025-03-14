package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int COUNT = 5;
        String line = br.readLine();
        final int LEN = 15;

        char[][] ch = new char[COUNT][LEN];
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < LEN; j++) {
                ch[i][j] = ' ';
            }
        }

        for (int i = 0; i < line.length(); i++) {
            ch[0][i] = line.charAt(i);
        }

        for (int i = 1; i < COUNT; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                ch[i][j] = temp.charAt(j);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < COUNT; j++) {
                if (ch[j][i] != ' ') {
                    result.append(ch[j][i]);
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
