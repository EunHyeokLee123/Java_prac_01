package CodeStudy.solution_1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static long tar;
    static int range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N =  Integer.parseInt(st.nextToken());
        tar = Long.parseLong(st.nextToken());
        range = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        if(N == 0) {
            System.out.println(1);
        }
        else {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(st.nextToken());
                if (!map.containsKey(num)) {
                    list.add(num);
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int result = 1;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) > tar) {
                    result += map.get(list.get(i));
                }
                else if(list.get(i) == tar) {
                    if(result + map.get(tar) > range) {
                        result = -1;
                    }
                    break;
                }
                else {
                    break;
                }
            }
            if(result != -1 && result <= range) {
                System.out.println(result);
            }
            else {
                System.out.println(-1);
            }
        }

        br.close();
    }

}
