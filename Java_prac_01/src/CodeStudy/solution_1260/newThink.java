package CodeStudy.solution_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class newThink {

    static int[][] path;
    static int point;
    static int start;
    // 경로 탐색 여부
    static boolean[] check;
    // DFS용 스택
    static Stack<Integer> Dre;
    // BFS용 큐
    static Queue<Integer> Bre;
    // DFS 경로 저장용
    static ArrayList<Integer> re1;
    // BFS 경로 저장용
    static ArrayList<Integer> re2;

    public static void DFS(int now){
        // 매개값 일단 스택에 삽입
        Dre.push(now);
        // 방문 처리
        check[now] = true;
        // 결과 리스트에 삽입
        re1.add(now);
        for (int i = 1; i <= point; i++) {
            // 방문하지 않은 지점 중 갈 수 있는 지점 확인
            if(path[now][i] == 1 && !check[i]){
                // 해당 지점에 대해서 DFS 재귀 호출
                DFS(i);
                // 해당 지점 탐색 후 방문 여부를 다시 초기화하지 않음
                // 그래야 처음 탐색한 경로만 출력할 수 있음.
            }
        }
        // 해당 지점 탐색 끝났으면 pop함
        Dre.pop();
        // 스택이 비었으면 -> 탐색이 끝남.
        if(Dre.isEmpty()) return;
    }

    public static void BFS(){
        // 시작점 방문 처리
        check[start] = true;
        // 결과 리스트에 삽입
        re2.add(start);
        // 현재 방문 지점을 시작점으로 초기화
        int tmp = start;
        while(true){
            // 해당 지점에서 갈 수 있는 모든 지점을 탐색
            for (int i = 1; i <= point; i++) {
                // 유효한 지점인지 확인
                if(path[tmp][i] == 1 && !check[i]){
                    // 갈 수 있는 모든 지점을 탐색 순서에 맞게 enque
                    Bre.offer(i); 
                    // 해당 지점 방문 처리
                    check[i] = true;
                    // 결과 리스트에 삽입
                    re2.add(i);
                }
                // 방문 여부를 초기화하지 않아서
                // 초기 탐색 경로만 출력됨.
            }
            // 큐가 비어있다면 모든 지점을 탐색한 거라서 탐색 종료
            if(Bre.isEmpty()){
                return;
            }else{
                // 큐가 비어있지 않다면 deque해서 현재 방문 지점 갱신
                tmp = Bre.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        point = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());
        start = Integer.parseInt(st1.nextToken());


        path = new int[point+1][point+1];
        check = new boolean[point+1];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            path[a1][a2] = 1;
            path[a2][a1] = 1;
        }
        // static 요소 초기화
        Dre = new Stack<>();
        Bre = new ArrayDeque<>();
        re1 = new ArrayList<>();
        re2 = new ArrayList<>();
    
        // DFS 실행
        DFS(start);
        for (int i = 0; i <= point; i++) {
            // 방문 여부 배열이 static이라 초기화
            check[i] = false;
        }
        // BFS 실행
        BFS();

        for (Integer i : re1) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        for (Integer i : re2) {
            System.out.printf("%d ",i);
        }
    }
}
