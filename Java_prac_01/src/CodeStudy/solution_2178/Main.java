package CodeStudy.solution_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int cols;
    static int rows;
    static int[][] path;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayDeque<int[]> arr;

    public static void BFS(int[] start){
        arr.offer(start);
        while(true){
            int len = arr.size();
            count++;
            for (int i = 0; i < len; i++) {
                int[] now = arr.poll();
                if(now[0] == cols - 1 && now[1] == rows - 1){
                    return;
                }
                else{
                    for (int j = 0; j < 4; j++) {
                        int x = now[0] + dx[j];
                        int y = now[1] + dy[j];
                        if(x >= 0 && x < cols && y >= 0 && y < rows){
                            if (path[x][y] == 1) {
                                path[x][y] = path[now[0]][now[1]] + 1;
                                int[] tmp = {x, y};
                                arr.offer(tmp);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        path = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                if(temp[j] == '1'){
                    path[j][i] = 1;
                }
                else{
                    path[j][i] = 0;
                }
            }
        }
        arr = new ArrayDeque<>();
        int[] start = {0,0};
        BFS(start);
        System.out.println(count);

        br.close();
    }

}
