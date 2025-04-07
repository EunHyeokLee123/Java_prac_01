package CodeStudy.solution_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static List<Integer> answer;
    static int tempResult = 0;

    public static int[] findCac(int cols, int rows, int[][] path){
        int[] result = {-1, -1};
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(path[i][j] == 1){
                    result[0] = i; result[1] = j;
                }
            }
        }
        return result;
    }

    public static void DFS(int cols, int rows, int[][] path, int[] tar){
        path[tar[0]][tar[1]] = 0;
        for (int i = 0; i < dx.length; i++) {
            if(tar[0]+dx[i]>=0 && tar[0]+dx[i]<cols &&
            tar[1]+dy[i]>=0 && tar[1]+dy[i]<rows){
                // 붙어있는 양배추를 찾음.
                if (path[tar[0]+dx[i]][tar[1]+dy[i]] == 1) {
                    int[] tmp = {tar[0]+dx[i], tar[1]+dy[i]};
                    DFS(cols, rows, path, tmp);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        for (int i = 0; i < caseCount; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int col1 = Integer.parseInt(st1.nextToken());
            int row1 = Integer.parseInt(st1.nextToken());
            int count1 = Integer.parseInt(st1.nextToken());
            int[][] path1 = new int[col1][row1];
            for (int j = 0; j < count1; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                path1[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())]
                        =1;
            }
            while(true) {
                int[] start = findCac(col1, row1, path1);
                if(start[0] == -1 && start[1]== -1){
                    break;
                }
                DFS(col1,row1,path1,start);
                tempResult++;
            }
            answer.add(tempResult);
            tempResult = 0;
        }
        for (Integer i : answer) {
            System.out.println(i);
        }


        br.close();
    }

}
