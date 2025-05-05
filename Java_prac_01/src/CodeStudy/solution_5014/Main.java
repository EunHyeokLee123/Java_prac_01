package CodeStudy.solution_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int total;
    static int now;
    static int target;
    static int up;
    static int down;


    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean[] visited;

    static int BFS(){

        int re = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(cur == target){
                    return re;
                }
                int a1 = cur + up;
                int a2 = cur - down;
                if(a1 <= total && !visited[a1]){
                    visited[a1] = true;
                    queue.offer(a1);
                }
                if(a2 >= 1 && !visited[a2]){
                    visited[a2] = true;
                    queue.offer(a2);
                }
            }
            re++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         total = Integer.parseInt(st.nextToken());
         now = Integer.parseInt(st.nextToken());
         target = Integer.parseInt(st.nextToken());
         up = Integer.parseInt(st.nextToken());
         down = Integer.parseInt(st.nextToken());
         visited = new boolean[total + 1];

        queue.offer(now);
        int result = BFS();

        if(result == -1){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(result);
        }

        br.close();
    }

}
