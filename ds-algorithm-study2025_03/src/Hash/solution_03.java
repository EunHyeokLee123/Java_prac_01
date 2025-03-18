package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st1.nextToken());
        int tar = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                for (int k = 2; k < len; k++) {
                    if (i !=j && j != k && i != k) {
                        int tmp = arr[i] + arr[j] + arr[k];
                        result.add(tmp);
                    }
                }
            }
        }
        // 내림차순으로 볼 수 있는 iterator
        Iterator<Integer> it = result.descendingIterator();
        Integer re;
        for (int i = 1; i <= tar-1 ; i++) {
            it.next();
        }
        re = it.next();
        System.out.println(re);

        br.close();
    }
}
