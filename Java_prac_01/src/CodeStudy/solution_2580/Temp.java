package CodeStudy.solution_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Temp {

    static int[][] arr;
    static boolean[] visited;
    static List<VisitNum[]> possibles;
    static List<Point> targets;

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 해당 지점에 가능한 숫자와 방문 여부를 표시하는 클래스
    public static class VisitNum {
        int number;
        boolean visited;

        public VisitNum(int number) {
            this.number = number;
            this.visited = false;
        }
    }

    public static boolean isDone() {
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }   return true;
    }

    // 해당 점의 좌표를 받아서, 3x3 정사각형 구역 중 어디에 존재하는 지 출력해주는 메소드
    // 탐색을 위해 정사각형 구역의 좌상단 첫 점을 리턴함.
    public static Point whereSector(Point p) {
        int x = p.x; int y = p.y;
        if(x < 3){
            if(y < 3){
                return new Point(0, 0);
            }
            else if(y < 6){
                return new Point(0, 3);
            }
            else{
                return new Point(0, 6);
            }
        }
        else if(x < 6){
            if(y < 3){
                return new Point(3, 0);
            }
            else if(y < 6){
                return new Point(3, 3);
            }
            else{
                return new Point(3, 6);
            }
        }
        else{
            if(y < 3){
                return new Point(6, 0);
            }
            else if(y < 6){
                return new Point(6, 3);
            }
            else{
                return new Point(6, 6);
            }
        }
    }

    // 0인 점에서 가능한 모든 숫자들만 걸러내는 메소드
    private static void firstTry(int start) {

        // 현재 0인 점
        Point now = targets.get(start);

        Point str = whereSector(now);
        // 가능한 최대 숫자의 개수
        int count = 9;
        // 먼저 해당 지점의 3x3에서 불가능한 숫자를 걸러냄.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int dx = str.x + j;
                int dy = str.y + i;
                int temp = arr[dy][dx];
                if(temp != 0) {
                    // 들어갈 수 없는 점은 해당 index의 값에 -1을 넣음
                    possibles.get(start)[temp] = new VisitNum(-1);
                    count--;
                }
            }
        }

        // 그 다음 가로에서 불가능한 숫자를 걸러냄
        for (int i = 0; i < 9 && i != now.x; i++) {
            int temp = arr[now.y][i];
            if(temp != 0) {
                // 들어갈 수 없는 점은 해당 index의 값에 -1을 넣음
                possibles.get(start)[temp] = new VisitNum(-1);
                count--;
            }
        }

        // 세로에서 불가능한 숫자를 걸러냄
        for (int i = 0; i < 9 && i != now.y; i++) {
            int temp = arr[i][now.x];
            if(temp != 0) {
                // 들어갈 수 없는 점은 해당 index의 값에 -1을 넣음
                possibles.get(start)[temp] = new VisitNum(-1);
                count--;
            }
        }
        // 0번째 index에는 가능한 숫자의 개수를 넣어놓자.
        possibles.get(start)[0] = new VisitNum(count);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int len = 9;
        // y,x
        arr = new int[len][len];
        // 0인 값들을 담을 리스트
        targets = new ArrayList<>();

        for (int i = 0; i < len; i++) {  // y
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < len; j++) {   // x
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp == 0) {
                    targets.add(new Point(j, i));
                }
            }
        }

        // 해당 지점의 방문 여부
        visited = new boolean[targets.size()];
        
        // 빈칸에 들어갈 수 있는 숫자와 방문여부를 담는 리스트
        // targets 와 1-1 대응
        possibles = new ArrayList<>();
        
        for (int i = 0; i < targets.size(); i++) {
            VisitNum[] temp = new VisitNum[10];
            for (int j = 1; j <= 9; j++) {
                temp[j] = new VisitNum(j);
            }
            possibles.add(temp);
        }

        for (int i = 0; i < targets.size(); i++) {
            firstTry(i);
        }

        /*for (VisitNum[] nums : possibles) {
            for (int i = 1; i < 10; i++) {
                VisitNum temp = nums[i];
                if(temp.number != -1) {
                    System.out.printf("%d ", temp.number);
                }
            }
            System.out.println("====================");
        }*/

        // 가능한 점이 하나밖에 없는 점들은 값을 넣어놓자.
        for (int i = 0; i < targets.size(); i++) {
            VisitNum[] temp = possibles.get(i);
            // 가능한 숫자의 개수가 1인 경우
            if(temp[0].number == 1){
                for (int j = 1; j < 10; j++) {
                    if(temp[j].number != -1){
                        Point tp = targets.get(i);
                        arr[tp.y][tp.x] = temp[j].number;
                        // 해당 점은 방문하지 않게끔 하기 위해 값을 (-1, -1)로 넣음
                        targets.set(i, new Point(-1, -1));
                    }
                }
            }
        }

        // DFS(start);
        
        br.close();
    }


}
