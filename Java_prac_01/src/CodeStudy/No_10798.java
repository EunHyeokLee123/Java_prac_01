package CodeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int count = 5;
        String line = br.readLine();
        final int len = 15;

        char[][] ch = new char[count][len];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < len; j++) {
                ch[i][j] = ' ';
            }
        }

        for (int i = 0; i < line.length(); i++) {
            ch[0][i] = line.charAt(i);
        }

        for (int i = 1; i < count; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                ch[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < count; j++) {
                if (ch[j][i] != ' ') {
                    System.out.print(ch[j][i]);
                }
            }
        }


        br.close();
    }
}
