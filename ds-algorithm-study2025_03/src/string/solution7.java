package string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class solution7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
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
