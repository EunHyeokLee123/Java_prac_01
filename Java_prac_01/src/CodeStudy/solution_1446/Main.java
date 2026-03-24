package CodeStudy.solution_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int Dest;
    static int MAX;
    static int[] path;

    static class Road {
        int start;
        int end;
        int len;
        Road(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Dest = Integer.parseInt(st.nextToken());
        MAX = Dest;
        path = new int[Dest + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;

        List<Road> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (end <= Dest) {
                Road temp = new Road(start, end, len);
                list.add(temp);
            }
        }

        for(int i = 0; i < Dest; i++) {
            path[i + 1] = Math.min(path[i + 1], path[i] + 1);

            for(Road r : list) {
                if(r.start == i) {
                    path[r.end] = Math.min(path[r.end], path[i] + r.len);
                }
            }
        }

        System.out.println(path[Dest]);

        br.close();
    }

}
