package CodeStudy.solution_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int len;
    static int window;
    static int max;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st.nextToken());
        window = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        // 첫 범위값 넣기
        for(int i = 0; i < window; i++) {
            temp += arr[i];
        }

        max = temp;
        map.put(temp, 1);

        int left = 0;
        int right = left + window - 1;

        while(true) {
            temp -= arr[left];
            left++;
            right++;
            if(right == len) break;
            temp += arr[right];
            if(temp > max) max = temp;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        if(max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(map.get(max));
        }

        br.close();
    }

}
