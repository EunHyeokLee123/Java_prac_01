package string;


import java.util.Scanner;

public class solution8 {

    // #은 1, *은 0

    static char toAscii(String in){
        int sum = 0;
        // i는 문자열의 인덱스, j는 지수의 인덱스
        for (int i = 0, j = 6; i < in.length(); i++, j--) {
            if(in.charAt(i)=='#'){
                sum += Math.pow(2, j);
            }
        }
        return (char)sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); int len = 7;
        sc.nextLine();
        String line = sc.nextLine();

        char[] result = new char[count];
        for (int i = 0, index = 0; i < line.length(); i += len, index++) {
            //result[index] = toAscii(line.substring(i, i + len));
            String temp = line.substring(i, i + len);
            temp = temp.replace('#', '1');
            temp = temp.replace('*', '0');
            result[index] = (char) Integer.parseInt(temp, 2);
        }

        System.out.println(new String(result).toUpperCase());


        sc.close();
    }
}
