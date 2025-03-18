package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_02 {

    static int num;
    static int len;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder re = new StringBuilder();
    static boolean[] check;
    static int[] dis;

    static void BFS(int num){
        check[num] = false;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int nv : graph.get(cur)) {
                if(check[nv]){
                    check[nv] = false;
                    queue.offer(nv);
                    dis[nv] = dis[cur] + 1;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        check = new boolean[num + 1];
        dis = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            check[i] = true;
        }
        graph = new ArrayList<>();
        for (int i = 0; i <= num ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
        }

        BFS(1);
        for (int i = 2; i <= num ; i++) {
            re.append(i).append(":").append(dis[i]).append("\n");
        }
        System.out.println(re);

        br.close();
    }
}
