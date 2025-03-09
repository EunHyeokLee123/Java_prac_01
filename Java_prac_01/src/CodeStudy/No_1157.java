package CodeStudy;

import java.util.Scanner;


public class No_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tar = sc.next();

        tar = tar.toLowerCase();
        // 알파벳의 개수는 26개
        int[] arr = new int[26];
        for (int i = 0; i < tar.length(); i++) {
            int idx = tar.charAt(i);
            arr[idx-97] = arr[idx-97] + 1;
        }
        int max = 0; boolean same = false;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
                same = false;
            }
            else if (arr[i] == max) {
                same = true;
            }
        }
        char result = (char)(idx+65);
        if(same)
            System.out.println("?");
        else
            System.out.println(result);

        sc.close();
    }
}
