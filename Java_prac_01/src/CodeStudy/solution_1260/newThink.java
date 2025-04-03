package CodeStudy.solution_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class newThink {

    static int[][] path;
    static int point;
    static int start;
    static boolean[] check;
    static Stack<Integer> Dre;
    static Queue<Integer> Bre;
    static ArrayList<Integer> re1;
    static ArrayList<Integer> re2;

    public static void DFS(int now){
        Dre.push(now);
        check[now] = true;
        re1.add(now);
        for (int i = 1; i <= point; i++) {
            if(path[now][i] == 1 && !check[i]){
                DFS(i);
            }
        }
        Dre.pop();
        if(Dre.isEmpty()) return;
    }

    public static void BFS(){
        check[start] = true;
        re2.add(start);
        int tmp = start;
        while(true){
            for (int i = 1; i <= point; i++) {
                if(path[tmp][i] == 1 && !check[i]){
                    Bre.offer(i); check[i] = true;
                    re2.add(i);
                }
            }
            if(Bre.isEmpty()){
                return;
            }else{
                tmp = Bre.poll();
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
        Dre = new Stack<>();
        Bre = new ArrayDeque<>();
        re1 = new ArrayList<>();
        re2 = new ArrayList<>();

        DFS(start);
        for (int i = 0; i <= point; i++) {
            check[i] = false;
        }
        BFS();

        for (Integer i : re1) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        for (Integer i : re2) {
            System.out.printf("%d ",i);
        }
    }
}
