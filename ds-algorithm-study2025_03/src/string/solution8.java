package string;

import java.util.Scanner;

public class solution8 {

    // #은 1, *은 0

    static char toAscii(String in){
        int sum = 0;
        for (int i = 0, j=6; i < in.length(); i++,j--) {
            if(in.charAt(i)=='#'){
                sum+=Math.pow(2, j);
            }
        }
        return (char)sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); int len = 7;
        sc.nextLine();
        String line = sc.nextLine();

        String[] str = new String[count];
        for (int i = 0, index = 0; i < line.length(); i+=len, index++) {
            str[index] = line.substring(i,i+len);
        }
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = toAscii(str[i]);
        }
        String re = new String(result);
        System.out.println(re.toUpperCase());


        sc.close();
    }
}
