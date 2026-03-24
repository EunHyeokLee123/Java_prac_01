package CodeStudy.solution_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list = new LinkedList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            list = new LinkedList<>();
            for (int j = 0; j < 20; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int count = 0;
            for(int j = 1; j < 20; j++) {
                for(int k = 0; k < j; k++) {
                    if(list.get(k) > list.get(j)) {
                        int temp = list.remove(j);
                        list.add(k, temp);
                        count += (j - k);
                        break;
                    }
                }
            }

            result[i] = count;

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(i != N - 1) {
                sb.append(i + 1).append(" ").append(result[i]).append("\n");
            }
            else {
                sb.append(i + 1).append(" ").append(result[i]);
            }
        }

        System.out.println(sb);



        br.close();
    }

}
