package string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String line = br.readLine();

        final int len = 7;

        char[] result = new char[count];
        for (int i = 0, index = 0; i < line.length(); i += len, index++) {
            //result[index] = toAscii(line.substring(i, i + len));
            String temp = line.substring(i, i + len);
            temp = temp.replace('#', '1');
            temp = temp.replace('*', '0');
            result[index] = (char) Integer.parseInt(temp, 2);
        }

        System.out.println(new String(result).toUpperCase());


    }
}
