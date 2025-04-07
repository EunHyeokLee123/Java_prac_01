package CodeStudy.solution_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    static int len;
    static ArrayList<ArrayList<Integer>> arr;
    static int count = 0;
    static LinkedList<Integer> resultlist = new LinkedList<>();
    static int temp = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static int[] findPa(){
        int[] result = {-1, -1};
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if(arr.get(i).get(j) == 1){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // 최대한 긴 길을 찾는 걸로 가자
    public static void DFS(int x, int y){
        // 방문 처리
        arr.get(x).set(y, -1);
        temp++;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >=0 && nx <len && ny < len){
                if(arr.get(nx).get(ny) == 1)
                    DFS(nx, ny);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if(line[j] == '1')
                    arr.get(i).add(1);
                else
                    arr.get(i).add(0);
            }
        }
        while(true){
            int[] tmp = findPa();
            if(tmp[0] == -1){
                break;
            }
            temp = 0;
            DFS(tmp[0], tmp[1]);
            resultlist.add(temp);
            count++;
        }
        Collections.sort(resultlist);
        System.out.println(count);
        for (Integer i : resultlist) {
            System.out.println(i);
        }

        br.close();
    }
}
