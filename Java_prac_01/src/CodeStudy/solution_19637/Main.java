package CodeStudy.solution_19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int len;
    static List<Integer> list = new ArrayList<>();
    static List<String> name = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void sayIt(int now) {
        int left = 0;
        int right = list.size() - 1;
        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(now <= list.get(mid)) {
                right = mid - 1;
                result = mid;
            }
            else{
                left = mid + 1;
            }
        }
        sb.append(name.get(result)).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String tp = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(set.add(num)) {
                list.add(num);
                name.add(tp);
            }
        }

        for(int i = 0; i < len; i++) {
            sayIt(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb);

        br.close();
    }

}
