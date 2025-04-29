package CodeStudy.solution_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Long> list = new ArrayList<>();

    // 유클리드 호제법!!
    static int whatGCD(int a1, int a2) {
        int a, b = 0;
        if (a1 > a2) {
            a = a1;
            b = a2;
        }
        else{
            a = a2;
            b = a1;
        }
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long calcGCD(int[] arr, int len){
        long result = 0;
        int left = 0; int right = 1;
        while(left < len - 1) {
            while(right < len){
                int mid = whatGCD(arr[left], arr[right]);
                result += mid;
                right++;
                //System.out.println(mid);
            }
            left++;
            right = left + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(calcGCD(arr, len));
        }
        for (Long i : list) {
            System.out.println(i);
        }






        br.close();
    }

}
