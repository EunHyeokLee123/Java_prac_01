package CodeStudy.solution_30804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; int end = len - 1;
        while(start < end){
            Set<Integer> set = new HashSet<>();
            for (int i = start; i <= end ; i++) {
                set.add(arr[i]);
            }
            if(set.size() <= 2){
                System.out.println(end - start + 1);
                break;
            }
            else{
                start++;
                set.clear();
                for (int i = start; i <= end; i++) {
                    set.add(arr[i]);
                }
                if(set.size() <= 2){
                    System.out.println(end - start + 1);
                    break;
                }
                else{
                    end--;
                }
            }
        }
        br.close();
    }
}
