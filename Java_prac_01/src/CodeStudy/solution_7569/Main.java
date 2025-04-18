package CodeStudy.solution_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int x;
    static int y;
    static int z;

    static byte[][][] path;

    static int[] dx = {0,0,0,0,1,-1};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {1,-1,0,0,0,0};

    static Queue<Point> queue = new LinkedList<>();

    public static boolean findTomato(){
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= y; j++) {
                for (int k = 1; k <= x; k++) {
                    if(path[k][j][i] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int BFS(){
        int count = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            count++;
            for(int i = 0; i < len; i++){
                Point arr = queue.poll();
                path[arr.x][arr.y][arr.z] = 1;
                for (int j = 0; j < 6; j++) {
                    int tx = arr.x + dx[j];
                    int ty = arr.y + dy[j];
                    int tz = arr.z + dz[j];
                    if(tx >= 1 && tx <= x && ty >= 1 && ty <= y &&
                            tz >= 1 && tz <= z){
                        if(path[tx][ty][tz] == 0){
                            queue.offer(new Point(tx, ty, tz));
                        }
                    }
                }
            }
        }
        if(findTomato()){
            return -1;
        }
        else{
            return --count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st1.nextToken());
        y = Integer.parseInt(st1.nextToken());
        z = Integer.parseInt(st1.nextToken());
        path = new byte[x + 1][y + 1][z + 1];
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= y; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= x; k++) {
                    byte temp = (byte)Integer.parseInt(st.nextToken());
                    path[k][j][i] = temp;
                    if(temp == 1){
                        Point tmp = new Point(k,j,i);
                        queue.offer(tmp);
                    }
                }
            }
        }


        int result = BFS();
        System.out.println(result);

        br.close();
    }

}
