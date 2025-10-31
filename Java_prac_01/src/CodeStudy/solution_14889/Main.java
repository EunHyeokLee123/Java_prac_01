package CodeStudy.solution_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]> list = new ArrayList<>();
    static int[] temp;
    static int[] candidate;

    static void Combination(int start, int now, int max) {
        if(now == max) {
            list.add(temp.clone());
            return;
        }
        for (int i = start; i < candidate.length; i++) {
            temp[now] = candidate[i];
            Combination(i + 1, now + 1, max);
        }
    }

    static int Calculate(int[] cand, int[][] arr) {
        int result = 0;
        for (int i = 0; i < cand.length; i++) {
            int tar = cand[i];
            for (int i1 : cand) {
                result += arr[tar][i1];
            }
        }
        return result;
    }

    static int[] Opposite(int[] cand, int length) {
        int[] result = new int[length / 2];
        int idx = 0;
        boolean[] visited = new boolean[length + 1];
        for (int i = 0; i < cand.length; i++) {
            visited[cand[i]] = true;
        }
        for (int i = 1; i <= length; i++) {
            if(!visited[i]) {
                result[idx] = i;
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        candidate = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            candidate[i] = i;
        }
        int[][] arr = new int[length + 1][length + 1];
        temp = new int[length/2];
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                arr[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }
        Combination(1, 0, length / 2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() / 2; i++) {

            int[] now = list.get(i);
            int a1 = Calculate(now, arr);
            int[] oppo = Opposite(now, length);
            int a2 = Calculate(oppo, arr);
            if(min > Math.abs(a1 - a2)) {
                min = Math.abs(a1 - a2);
            }
        }

        System.out.println(min);

        br.close();
    }

}
