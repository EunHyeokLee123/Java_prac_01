package CodeStudy.solution_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    static int len;
    static ArrayList<ArrayList<Integer>> arr;
    static int count = 0;
    static LinkedList<Integer> list = new LinkedList<>();
    static int temp = 0;

    // 최대한 긴 길을 찾는 걸로 가자
    public static void DFS(int x, int y){
        
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
                    arr.get(i).add(j);
            }
        }







        br.close();
    }
}
