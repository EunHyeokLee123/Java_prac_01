package CodeStudy.solution_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0 , 0};
    static int[] dy = {0, 0, 1 , -1};
    static int[][] path;
    static boolean[][] visited;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int x;
    static int y;


    /*static int BFS(){
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(path[i][j] == 2){
                    queue.offer(i);
                }
            }
        }

        while(!queue.isEmpty()){

        }
    }*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        path = new int[y][x];
        visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                path[i][j] = Integer.parseInt(st1.nextToken());
            }
        }



        br.close();
    }

}
