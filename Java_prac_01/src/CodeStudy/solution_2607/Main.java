package CodeStudy.solution_2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] count = new int[26];
    // 길이가 같은 지 여부
    static boolean flag = true;

    static int[] getCount(char[] com) {
        int[] res = new int[26];
        for(int i = 0; i < com.length; i++) {
            res[com[i] - 'A']++;
        }
        return res;
    }

    static boolean isSimilar(int[] a1, int[] a2) {
        int diff = 0;
        for(int i = 0; i < 26; i++) {
            if(a1[i] != a2[i]) {
                diff += Math.abs(a1[i] - a2[i]);
            }
            if(diff > 2) {
                return false;
            }
        }
        if(diff == 2 && !flag) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();
        count = getCount(target);

        int result = 0;
        for(int i = 0; i < len - 1; i++) {
            char[] tp = br.readLine().toCharArray();
            int[] com = getCount(tp);
            // 길이가 다른 경우
            if(tp.length != target.length) {
                flag = false;
            }
            if(isSimilar(com, count)) {
                result++;
            }
            flag = true;
        }


        System.out.println(result);



        br.close();
    }

}
