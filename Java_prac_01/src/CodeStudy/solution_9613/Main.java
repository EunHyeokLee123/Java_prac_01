package CodeStudy.solution_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int whatGCD(int a, int b) {
        int max, min = 0;
        if(a <= b){
            max =  b;
            min = a;
        }
        else{
            max = a;
            min = b;
        }
        for (int i = 1; i < (int) Math.sqrt(min); i++) {
            if(min % i == 0){
                int temp = min / i;
                if(max % temp == 0){
                    return temp;
                }
            }
        }
        return 1;
    }

    static int calcGCD(int[] arr, int len){
        int result = 0;
        int left = 0; int right = 1;
        while(left < len - 1) {
            while(right < len){

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }



        }






        br.close();
    }

}
