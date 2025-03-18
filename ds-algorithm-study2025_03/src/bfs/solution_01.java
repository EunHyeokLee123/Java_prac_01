package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_01 {

    static int[] dis = {1, -1, 5};
    static int[] check;
    static Queue<Integer> queue = new ArrayDeque<>();

    private static void BFS(int s, int e){
        check = new int[10001]; // 0번 없이 문제에서 좌표의 범위가 10000으로 정의되서.
        check[s] = 1; // 시작점은 지나갔음.
        queue.add(s); // 시작점 큐에 넣기
        int level = 0; // 점프 횟수
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                for (int j = 0; j < dis.length; j++) {
                    int next = cur + dis[j];
                    if(next == e){   // 목표를 찾았다면 현재 레벨에서 +1해서 출력
                        System.out.println(level + 1);
                        return;
                    }
                    // check배열 확인해서 이미 갔던 곳은 다시 방문하지 않도록 제어
                    else if(check[next] == 0 && next >= 1 && next <= 10000){
                        check[next] = 1;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int now = Integer.parseInt(st.nextToken());
        int tar = Integer.parseInt(st.nextToken());

        BFS(now, tar);


        br.close();
    }
}
