package CodeStudy.solution_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Oper {
        int len;
        String dir;
        Oper(int len, String dir) {
            this.len = len;
            this.dir = dir;
        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> snake = new ArrayList<Point>();
    static char way = 'e';
    static int[][] arr;
    static boolean[][] visit;
    static int time = 1;
    static int N;

    static void getDir(char tar) {
        if(way == 'e') {
            if(tar == 'D') {
                way = 's';
            }
            else {
                way = 'n';
            }
        }
        else if(way == 'w') {
            if(tar == 'D') {
                way = 'n';
            }
            else {
                way = 's';
            }
        }
        else if(way == 'n') {
            if(tar == 'D') {
                way = 'e';
            }
            else {
                way = 'w';
            }
        }
        else {
            if(tar == 'D') {
                way = 'w';
            }
            else {
                way = 'e';
            }
        }
    }

    static boolean Step() {
            Point head = snake.get(0);

            if(way == 'e') {
                if(head.x + 1 <= N) {
                    // 꼬리가 잘리는 경우
                    if(arr[head.y][head.x + 1] == 0) {
                        // 갈려는 곳이 뱀의 몸인 경우
                        if(visit[head.y][head.x + 1]) {
                            Point tail = snake.get(snake.size() - 1);
                            // 갈려는 곳이 꼬리인 경우 --> 문제가 되지 않는 상황임
                            if(head.x + 1 == tail.x && head.y == tail.y) {
                                // 꼬리 삭제
                                snake.remove(snake.size() - 1);
                                // 꼬리를 머리로
                                snake.add(0, tail);
                            }
                            // 갈려는 곳이 꼬리가 아닌 경우
                            else {
                                // 실패
                                return false;
                            }
                        }
                        // 겹치지 않는 경우 -> 문제 없음
                        else {
                            Point tail = snake.get(snake.size() - 1);
                            visit[tail.y][tail.x] = false;
                            // 꼬리 삭제
                            snake.remove(snake.size() - 1);
                            // 새로운 머리
                            snake.add(0, new Point(head.x + 1, head.y));
                            visit[head.y][head.x + 1] = true;
                        }
                    }
                    // 꼬리가 잘리지 않는 경우
                    else {
                        // 몸체와 겹치는 경우
                        if(visit[head.y][head.x + 1]) {
                            return false;
                        }
                        // 몸과 겹치지 않는 경우
                        else {
                            visit[head.y][head.x + 1] = true;
                            snake.add(0, new Point(head.x + 1, head.y));
                        }
                    }
                    arr[head.y][head.x + 1] = 0;
                }
                // 벽과 부딪히는 경우
                else {
                    return false;
                }
            }
            else if(way == 'w') {
                if(head.x - 1 > 0) {
                    // 꼬리가 잘리는 경우
                    if(arr[head.y][head.x - 1] == 0) {
                        // 갈려는 곳이 뱀의 몸인 경우
                        if(visit[head.y][head.x - 1]) {
                            Point tail = snake.get(snake.size() - 1);
                            // 갈려는 곳이 꼬리인 경우 --> 문제가 되지 않는 상황임
                            if(head.x - 1 == tail.x && head.y == tail.y) {
                                // 꼬리 삭제
                                snake.remove(snake.size() - 1);
                                // 꼬리를 머리로
                                snake.add(0, tail);
                            }
                            // 갈려는 곳이 꼬리가 아닌 경우
                            else {
                                // 실패
                                return false;
                            }
                        }
                        // 겹치지 않는 경우 -> 문제 없음
                        else {
                            Point tail = snake.get(snake.size() - 1);
                            visit[tail.y][tail.x] = false;
                            // 꼬리 삭제
                            snake.remove(snake.size() - 1);
                            // 새로운 머리
                            snake.add(0, new Point(head.x - 1, head.y));
                            visit[head.y][head.x - 1] = true;
                        }
                    }
                    // 꼬리가 잘리지 않는 경우
                    else {
                        // 몸체와 겹치는 경우
                        if(visit[head.y][head.x - 1]) {
                            return false;
                        }
                        // 몸과 겹치지 않는 경우
                        else {
                            visit[head.y][head.x - 1] = true;
                            snake.add(0, new Point(head.x - 1, head.y));
                        }
                    }
                    arr[head.y][head.x - 1] = 0;
                }
                // 벽과 부딪히는 경우
                else {
                    return false;
                }
            }
            else if (way == 's') {
                if(head.y + 1 <= N) {
                    // 꼬리가 잘리는 경우
                    if(arr[head.y + 1][head.x] == 0) {
                        // 갈려는 곳이 뱀의 몸인 경우
                        if(visit[head.y + 1][head.x]) {
                            Point tail = snake.get(snake.size() - 1);
                            // 갈려는 곳이 꼬리인 경우 --> 문제가 되지 않는 상황임
                            if(head.x == tail.x && head.y + 1 == tail.y) {
                                // 꼬리 삭제
                                snake.remove(snake.size() - 1);
                                // 꼬리를 머리로
                                snake.add(0, tail);
                            }
                            // 갈려는 곳이 꼬리가 아닌 경우
                            else {
                                // 실패
                                return false;
                            }
                        }
                        // 겹치지 않는 경우 -> 문제 없음
                        else {
                            Point tail = snake.get(snake.size() - 1);
                            visit[tail.y][tail.x] = false;
                            // 꼬리 삭제
                            snake.remove(snake.size() - 1);
                            // 새로운 머리
                            snake.add(0, new Point(head.x, head.y + 1));
                            visit[head.y + 1][head.x] = true;
                        }
                    }
                    // 꼬리가 잘리지 않는 경우
                    else {
                        // 몸체와 겹치는 경우
                        if(visit[head.y + 1][head.x]) {
                            return false;
                        }
                        // 몸과 겹치지 않는 경우
                        else {
                            visit[head.y + 1][head.x] = true;
                            snake.add(0, new Point(head.x, head.y + 1));
                        }
                    }
                    arr[head.y + 1][head.x] = 0;
                }
                // 벽과 부딪히는 경우
                else {
                    return false;
                }
            }
            // 북쪽
            else {
                if(head.y - 1 > 0) {
                    // 꼬리가 잘리는 경우
                    if(arr[head.y - 1][head.x] == 0) {
                        // 갈려는 곳이 뱀의 몸인 경우
                        if(visit[head.y - 1][head.x]) {
                            Point tail = snake.get(snake.size() - 1);
                            // 갈려는 곳이 꼬리인 경우 --> 문제가 되지 않는 상황임
                            if(head.x == tail.x && head.y - 1 == tail.y) {
                                // 꼬리 삭제
                                snake.remove(snake.size() - 1);
                                // 꼬리를 머리로
                                snake.add(0, tail);
                            }
                            // 갈려는 곳이 꼬리가 아닌 경우
                            else {
                                // 실패
                                return false;
                            }
                        }
                        // 겹치지 않는 경우 -> 문제 없음
                        else {
                            Point tail = snake.get(snake.size() - 1);
                            visit[tail.y][tail.x] = false;
                            // 꼬리 삭제
                            snake.remove(snake.size() - 1);
                            // 새로운 머리
                            snake.add(0, new Point(head.x, head.y - 1));
                            visit[head.y - 1][head.x] = true;
                        }
                    }
                    // 꼬리가 잘리지 않는 경우
                    else {
                        // 몸체와 겹치는 경우
                        if(visit[head.y - 1][head.x]) {
                            return false;
                        }
                        // 몸과 겹치지 않는 경우
                        else {
                            visit[head.y - 1][head.x] = true;
                            snake.add(0, new Point(head.x, head.y - 1));
                        }
                    }
                    arr[head.y - 1][head.x] = 0;
                }
                // 벽과 부딪히는 경우
                else {
                    return false;
                }
            }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        int co = Integer.parseInt(br.readLine());

        for(int i = 0; i < co; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        int count = Integer.parseInt(br.readLine());
        Oper[] ops = new Oper[count];
        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            ops[i] = new Oper(a, dir);
        }

        snake.add(new Point(1, 1));
        visit[1][1] = true;
        int idx = 0;
        while(true) {
            if(!Step()) {
                break;
            }
            if(idx < count && ops[idx].len == time) {
                getDir(ops[idx].dir.charAt(0));
                idx++;
            }
            time++;

        }

        System.out.println(time);


        br.close();
    }

}
