package CodeStudy;

import java.util.Scanner;

public class No_25206 {

    static double whatScore(String str){
        if(str.equals("A+"))
            return 4.5;
        else if (str.equals("A0"))
            return 4.0;
        else if (str.equals("B+"))
            return 3.5;
        else if (str.equals("B0"))
            return 3.0;
        else if (str.equals("C+"))
            return 2.5;
        else if (str.equals("C0"))
            return 2.0;
        else if (str.equals("D+"))
            return 1.5;
        else if (str.equals("D0"))
            return 1.0;
        else if (str.equals("F"))
            return 0.0;
        else
            return  5.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double re = 0.0; double time = 0.0;
        for (int i = 0; i < 20; i++) {
            String ins = sc.nextLine();
            String[] strs = ins.split(" ");
            double tmp = whatScore(strs[2]);
            if(tmp != 5.0){
                re += Double.parseDouble(strs[1]) * tmp;
                time += Double.parseDouble(strs[1]);
            }
        }
        re /= time;
        System.out.println(re);
        sc.close();
    }
}
