package CodeStudy.solution_1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static String[] arr;
    static boolean[] visited = new boolean[26];
    static int[] index;

    static boolean doFirst(int idx, String word) {
        String[] temp = word.split(" ");
        char first = temp[0].charAt(0);
        int num = Character.toLowerCase(first) - 'a';

        if(visited[num]) {
            for(int j = 1; j < temp.length; j++) {
                int next = Character.toLowerCase(temp[j].charAt(0)) - 'a';
                if(!visited[next]) {
                    visited[next] = true;
                    int length = 0;
                    for(int k = 0; k < j; k++) {
                        length += temp[k].length() + 1;
                    }
                    index[idx] = length;
                    return true;
                }
            }
        }
        else {
            visited[num] = true;
            index[idx] = 0;
            return true;
        }

        return false;
    }

    static boolean doSecond(int idx, String word) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != ' ') {
                int num = Character.toLowerCase(word.charAt(i)) - 'a';
                if(!visited[num]) {
                    visited[num] = true;
                    index[idx] = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N + 1];
        index = new int[N + 1];
        Arrays.fill(index, -1);
        for(int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        br.close();

        for(int i = 1; i <= N; i++) {
            if(!doFirst(i, arr[i])) {
                doSecond(i, arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            String result = "";
            if(index[i] != -1) {
                for(int j = 0; j < arr[i].length(); j++) {
                    if(index[i] == j) {
                        result += "[";
                        result += arr[i].charAt(j);
                        result += "]";
                    }
                    else {
                        result += arr[i].charAt(j);
                    }
                }
            }
            else {
                result = arr[i];
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

}
