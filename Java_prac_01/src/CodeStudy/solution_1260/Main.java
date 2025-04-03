package CodeStudy.solution_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int point;
    static int start;
    static int[][] path;
    static List<Integer> result = new ArrayList<>();
    static boolean[] check;

    public static void DFS(int now){
        check[now] = true;
        result.add(now);
        for (int i = 1; i <= point; i++) {
            if(path[now][i] == 1 && !check[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int now){
        int tmp = now;
        int next = 0;
        check[now] = true;
        result.add(now);
        while(true){
            for (int j = 1; j <= point; j++) {
                if(path[tmp][j]==1 && !check[j]){
                    result.add(j);
                    check[j] = true;
                }
            }
            if(result.size() != point){
                next++;
                if (result.size() != next + 1) {
                    tmp = result.get(next);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        point = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());
        start = Integer.parseInt(st1.nextToken());


        path = new int[point+1][point+1];
        check = new boolean[point+1];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            path[a1][a2] = 1;
            path[a2][a1] = 1;
        }

        DFS(start);
        StringBuilder str1 = new StringBuilder();
        for (Integer i : result) {
            str1.append(i).append(" ");
        }
        System.out.println(str1);
        result.clear();
        for (int i = 1; i <= point ; i++) {
            check[i] = false;
        }

        BFS(start);
        StringBuilder sb2 = new StringBuilder();
        for (Integer i : result) {
            sb2.append(i).append(" ");
        }
        br.close();

        System.out.println(sb2);

    }
}
