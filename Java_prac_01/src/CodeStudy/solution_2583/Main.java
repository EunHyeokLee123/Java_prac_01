package CodeStudy.solution_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[][] path;
    static int rows;
    static int cols;
    static ArrayList<Integer> solution;
    static int mid = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static int[] findZero(){
        int result[] = {-1, -1};
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(path[i][j] == 0){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void DFS(int[] start){
        mid++;
        path[start[0]][start[1]] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = start[0] + dx[i];
                int y = start[1] + dy[i];
                int[] tmp = {x, y};
                if(x >= 0 && x < cols && y >= 0 && y < rows){
                    if(path[x][y] == 0){
                        DFS(tmp);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        rows = Integer.parseInt(st1.nextToken());
        cols = Integer.parseInt(st1.nextToken());
        path = new int[cols][rows];
        solution = new ArrayList<>();
        int count = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // x 축
            for (int j = x1; j < x2; j++) {
                // y 축
                for (int k = y1; k < y2; k++) {
                    // 눈금을 1로
                    path[j][k] = 1;
                }
            }
        }
        int[] temp = findZero();
        while(temp[0] != -1 && temp[1] != -1){
            DFS(temp);
            solution.add(mid);
            mid = 0;
            temp = findZero();
        }
        System.out.println(solution.size());
        Collections.sort(solution);
        for (Integer i : solution) {
            System.out.print(i+" ");
        }

        br.close();
    }

}
