package CodeStudy.solution_20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static boolean[] exist;

    static int getMin(int start, char tar, int k, String line) {
        int count = 1;
        for(int i = start + 1; i < line.length(); i++) {
            if(line.charAt(i) == tar) {
                count++;
            }
            if(count == k) {
                return i - start + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int u = 0; u < N; u++){
            String line = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Map<Character, List<Integer>> map = new HashMap<>();
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                    list.add(c);
                }
                map.get(c).add(i);
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++){
                if(map.get(list.get(i)).size() >= k){
                    for(int j = 0; j <= map.get(list.get(i)).size() - k; j++){
                        int temp = map.get(list.get(i)).get(j + k - 1) - map.get(list.get(i)).get(j) + 1;
                        if(temp > max){
                            max = temp;
                        }
                        if(temp < min){
                            min = temp;
                        }
                    }
                }
            }
            if(max == Integer.MIN_VALUE){
                sb.append("-1").append("\n");
            }
            else {
                sb.append(min + " " + max).append("\n");
            }
        }

        System.out.println(sb);

        br.close();


    }

}
