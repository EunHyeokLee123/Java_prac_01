package CodeStudy.solution_8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Nation {
        int gold;
        int silver;
        int bronze;
        Nation(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    static Nation[] arr;
    // target 보다 순위가 위인 국가의 개수
    static int count = 1;

    static void isUp(Nation now, Nation tar) {
        // 순위가 위에 있는 경우
        if(now.gold > tar.gold) {
            count++;
        }
        else if(now.gold == tar.gold) {
            if(now.silver > tar.silver) {
                count++;
            }
            else if(now.silver == tar.silver) {
                if(now.bronze > tar.bronze) {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int tar = Integer.parseInt(st.nextToken());

        arr = new Nation[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            Nation temp = new Nation(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[idx] = temp;
        }

        for(int i = 1; i <= n; i++) {
            if(i != tar) {
                isUp(arr[i], arr[tar]);
            }
        }

        System.out.println(count);

        br.close();

    }

}
