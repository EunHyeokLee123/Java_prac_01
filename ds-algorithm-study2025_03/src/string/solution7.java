package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class solution7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int idx = 0;
        while(idx < line.length()){
            char tar = line.charAt(idx);
            int count = 0;
            for (int i = idx; i < line.length(); i++) {
                if(tar != line.charAt(i))
                    break;
                idx++; count++;
            }
            if(count == 1)
                System.out.printf("%c", tar);
            else
                System.out.printf("%c%d",tar,count);
        }

    }

}
