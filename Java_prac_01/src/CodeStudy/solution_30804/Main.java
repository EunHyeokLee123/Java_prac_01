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

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0; int start = 0;
        for (int right = 0; right < len; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > 2){
                map.put(arr[start], map.get(arr[start]) - 1);
                if(map.get(arr[start]) == 0){
                    map.remove(arr[start]);
                }
                start++;
            }
            max = Math.max(max, right - start + 1);
        }
        System.out.println(max);


        br.close();
    }
}
