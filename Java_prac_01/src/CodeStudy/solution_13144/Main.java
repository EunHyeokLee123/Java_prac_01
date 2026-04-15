package CodeStudy.solution_13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> set = new HashSet<>();
        long result = 0;
        int left = 0;
        int right = 0;
        while(right < N) {
            while(set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }

            set.add(arr[right]);

            result += right - left + 1;
            right++;
        }

        System.out.println(result);

    }

}
