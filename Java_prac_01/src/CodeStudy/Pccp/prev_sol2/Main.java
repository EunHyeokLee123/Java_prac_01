package CodeStudy.Pccp.prev_sol2;

import java.util.HashSet;
import java.util.Set;

public class Main {


    class Solution {

        class Point {
            int x;
            int y;
            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
            void moveX(int x) {
                this.x = x;
            }
            void moveY(int y) {
                this.y = y;
            }
        }

        public int solution(int[][] points, int[][] routes) {
            int answer = 0;
            Point[] arr = new Point[routes.length];
            boolean[] ended = new boolean[routes.length];
            Set<int[]> first = new HashSet<>();
            for (int i = 0; i < routes.length; i++) {
                int nowY = points[routes[i][0] - 1][0];
                int nowX = points[routes[i][0] - 1][1];
                arr[i] = new Point(nowY, nowX);
                // 만일 출발지와 목적지가 같은 경우
                if(routes[i][0] == routes[i][1]) {
                    ended[i] = true;
                }
                // 움직이기전에 이미 충돌한 상태 확인용
                first.add(new int[]{nowY, nowX});
            }

            if(first.size() != routes.length) {
                answer++;
            }

            while(true) {
                int moved = 0;
                // 탐색 종료 확인용.
                // 하나라도 움직였다면 flag = false
                boolean flag = true;
                Set<int[]> set = new HashSet<>();
                // 일단 움직이자.
                for (int i = 0; i < arr.length; i++) {
                    if(!ended[i]) {
                        flag = false;
                        if(arr[i].y < points[routes[i][1] - 1][0]) {
                            moved++;
                            arr[i].moveX(arr[i].y + 1);
                            set.add(new int[]{arr[i].x, arr[i].y});
                        }
                        else if (arr[i].y > points[routes[i][1] - 1][0]) {
                            moved++;
                            arr[i].moveY(arr[i].y - 1);
                            set.add(new int[]{arr[i].x, arr[i].y});
                        }
                        else {
                            if(arr[i].x < points[routes[i][1] - 1][1]) {
                                moved++;
                                arr[i].moveX(arr[i].x + 1);
                                set.add(new int[]{arr[i].x, arr[i].y});
                            }
                            else if (arr[i].x > points[routes[i][1] - 1][1]) {
                                moved++;
                                arr[i].moveX(arr[i].x - 1);
                                set.add(new int[]{arr[i].x, arr[i].y});
                            }
                            else {
                                ended[i] = true;
                            }
                        }
                        // 이동한 곳이 목적지인 경우
                        if(arr[i].y == points[routes[i][1] - 1][0] &&
                                arr[i].x == points[routes[i][1] - 1][1]) {
                            ended[i] = true;
                        }
                    }
                }
                if(flag) {
                    break;
                }
                if(moved > 0 && moved > set.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }


}
