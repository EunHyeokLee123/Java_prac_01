package CodeStudy.solution_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] result;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int times = 0;
    static boolean find = false;
    static ArrayDeque<int[]> road;

    public static boolean canGo(int[] now, int[] des, int len){
        for (int i = 0; i < 8; i++) {
            int x = now[0] + dx[i];
            int y = now[1] + dy[i];
            if(x >= 0 && x< len && y >= 0 && y < len){
                if(x == des[0] && y == des[1]){
                    return true;
                }
            }
        }
        return false;
    }


    public static void BFS(int[] start, int[] des, int len){
        if (start != des) {
            road.offer(start);
        }
        else{
            return;
        }
        while(true){
            int[] now = road.poll();
            for (int i = 0; i < 8; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && x< len && y >= 0 && y < len){
                    if(x == des[0] && y == des[1]){
                        return;
                    }
                    else{
                        int[] tmp = {x, y};
                        road.offer(tmp);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        result = new int[count];
        road = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int[] start = {Integer.parseInt(st1.nextToken()),
                    Integer.parseInt(st1.nextToken())};

            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int[] desti = {Integer.parseInt(st2.nextToken())
                    ,Integer.parseInt(st2.nextToken())};

            BFS(start, desti, len);
            result[i] = times;
            times = 0;
        }

        for (int i : result) {
            System.out.println(i);
        }

        br.close();
    }

}
