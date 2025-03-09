package CodeStudy;

import java.util.Scanner;

public class No_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] re = new boolean[31];

        for (int i = 0; i < 28; i++) {
            re[sc.nextInt()] = true;
        }
        for (int i = 1; i < re.length; i++) {
            if(re[i] == false){
                System.out.println(i);
            }
        }
    }
}
