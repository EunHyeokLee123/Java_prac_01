package CodeStudy;

import java.util.Scanner;

public class No_25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[20];
        for (int i = 0; i < str.length; i++) {
            String tmp = sc.next();
            tmp = tmp.substring(tmp.length()-2);
            tmp = tmp.trim();
            str[i] = tmp;
        }
        double re = 0.0; int count = 20;
        for (String s : str) {
            if(s.equals("A+"))
                re += 4.5;
            else if(s.equals("A0"))
                re += 4.0;
            else if (s.equals("B+"))
                re+=3.5;
            else if (s.equals("B0"))
                re+=3.0;
            else if (s.equals("C+"))
                re+=2.5;
            else if (s.equals("C0"))
                re+=2.0;
            else if (s.equals("D+"))
                re+=1.5;
            else if (s.equals("D0"))
                re+=1.0;
            else if (s.equals("F"))
                re+=0.0;
            else if (s.equals("P"))
                count--;
        }
        re = re/count;
        System.out.println(re);
        sc.close();
    }
}
