package CodeStudy.solution_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] path;
    static boolean[] visited;
    static int[] result;

    public static void BFS(int count){
        ArrayDeque<Integer> road = new ArrayDeque<>();
        road.offer(1); result[1] = 1000;
        while(!road.isEmpty()){
            int size = road.size();
            for (int i = 0; i < size; i++) {
                int tar = road.poll();
                for (int j : path[tar]) {
                    if(result[j] == 0){
                        result[j] = tar;
                        road.offer(j);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        result = new int[count + 1];
        path = new List[count + 1];

        for (int i = 1; i <= count; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < count - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            path[a1].add(a2);
            path[a2].add(a1);
        }

        BFS(count);

        for (int i = 2; i <= count; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }

}
