package CodeStudy.solution_13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] price;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        price = new int[len];
        road = new int[len - 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < len - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < len; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0;
        int next = 1;
        long total = 0;
        while(next < len - 1) {
            // 다음 도시에서 주유를 할 필요가 없는 경우
            // 지금 도시가 더 저렴함.
            if(price[next] >= price[now]) {
                next++;
            }
            // 다음 도시가 더 저렴한 경우
            else {
                for(int i = now; i < next; i++) {
                    total += (long) price[now] * road[i];
                }
                now = next;
                next++;
            }
        }

        // 탐색이 끝난 경우
        if(now != len - 1) {
            for(int i = now; i < next; i++) {
                total += (long) price[now] * road[i];
            }
        }

        System.out.println(total);

        br.close();
    }

}
