package CodeStudy.solution_9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int length;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            length = Integer.parseInt(br.readLine());
            arr = new int[length];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[j] = temp;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            List<Integer> no = new ArrayList<>();
            for(int tar : map.keySet()) {
                if(map.get(tar) < 6) {
                    no.add(tar);
                }
            }
            int idx = 1;
            HashMap<Integer, List<Integer>> mp = new HashMap<>();
            for(int j = 0; j < arr.length; j++) {
                if(!no.contains(arr[j])) {
                    if(!mp.containsKey(arr[j])) {
                        mp.put(arr[j], new ArrayList<>());
                    }
                    if(mp.get(arr[j]).size() < 5) {
                        mp.get(arr[j]).add(j);
                    }
                    idx++;
                }
            }

        }



        br.close();
    }

}
