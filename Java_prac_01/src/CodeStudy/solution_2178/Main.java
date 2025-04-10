package CodeStudy.solution_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cols;
    static int rows;
    static int[][] path;
    static int count;
    static int temp = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void DFS(int[] now){
        path[now[1]][now[0]] = 0;
        if(now[0] == cols - 1 && now[1] == rows - 1){
            temp++;
            if(temp < count){
                count = temp;
            }
        }
        else{
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && x < cols && y >= 0 && y < rows){
                    if(path[x][y] == 1){
                        temp++;
                        if (temp < count) {
                            int[] tmp = {x, y};
                            DFS(tmp);
                        }
                    }
                }
            }
        }
        path[now[1]][now[0]] = 1;
        temp--;
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
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(path[j][i]);
//            }
//            System.out.println();
//        }
        count = cols * rows;
        int[] start = {0,0};
        DFS(start);
        System.out.println(count);

        br.close();
    }

}
