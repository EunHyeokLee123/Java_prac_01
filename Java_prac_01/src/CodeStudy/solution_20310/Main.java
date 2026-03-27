package CodeStudy.solution_20310;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int one;
    static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                one++;
            }
        }
        zero = arr.length - one;

        // 1은 앞에서 부터 지우자
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                count++;
                arr[i] = 'a';
            }
            if(count == one / 2) {
                break;
            }
        }

        count = 0;
        // 0은 뒤에서부터 지우자
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == '0') {
                count++;
                arr[i] = 'a';
            }
            if(count == zero / 2) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 'a') {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb);

        br.close();
    }

}
