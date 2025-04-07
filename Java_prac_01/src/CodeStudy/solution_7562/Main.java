package CodeStudy.solution_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] result;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};



    public static int BFS(int[] start, int[] des, int len){
        ArrayDeque<int[]> road = new ArrayDeque<>();
        boolean[][] visited = new boolean[len][len];
        int times = 0;
        if(Arrays.equals(start, des)){
            return times;
        }
        else{
            road.offer(start);
            visited[start[0]][start[1]] = true;
            times++;
        }
        while(!road.isEmpty()){
            int size = road.size();
            for (int j = 0; j < size; j++) {
                int[] now = road.poll();
                for (int i = 0; i < 8; i++) {
                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];
                    if(x >= 0 && y >= 0 && x < len && y < len){
                        int[] tmp = {x, y};
                        if(!visited[x][y]){
                            if(des[0] == x && des[1] == y){
                                return times;
                            }
                            else{
                                road.offer(tmp);
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
            times++;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        result = new int[count];
        for (int i = 0; i < count; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int[] start = {Integer.parseInt(st1.nextToken()),
                    Integer.parseInt(st1.nextToken())};

            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int[] desti = {Integer.parseInt(st2.nextToken())
                    ,Integer.parseInt(st2.nextToken())};

            int times = BFS(start, desti, len);
            result[i] = times;
        }

        for (int i : result) {
            System.out.println(i);
        }

        br.close();
    }

}
