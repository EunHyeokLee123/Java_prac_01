package CodeStudy.solution_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

    public static List<Integer> canRectNum (Point now){
        boolean[] nums = new boolean[11];

        Point start = whereSector(now);

        int now_x = start.x; int now_y = start.y;
        for (int i = 0; i < 3; i++) {

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int len = 9;
        // y,x
        arr = new int[len][len];
        // 0인 값들을 담을 리스트
        List<Point> targets = new ArrayList<>();

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
        boolean[] visited = new boolean[targets.size()];









        br.close();
    }

}
