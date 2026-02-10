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
    static int way = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int time = 0;
    static int N;
    // 동서남북
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static void getDir(char tar) {
        if(way == 0) {
            if(tar == 'D') {
                way = 2;
            }
            else {
                way = 3;
            }
        }
        else if(way == 1) {
            if(tar == 'D') {
                way = 3;
            }
            else {
                way = 2;
            }
        }
        else if(way == 2) {
            if(tar == 'D') {
                way = 1;
            }
            else {
                way = 0;
            }
        }
        else if(way == 3) {
            if(tar == 'D') {
                way = 0;
            }
            else {
                way = 1;
            }
        }
    }

    static boolean Step() {
        Point head = snake.get(0);
        int nx = head.x + dx[way];
        int ny = head.y + dy[way];
        // 벽 여부
        if(nx > 0 && nx <= N && ny > 0 && ny <= N) {
            // 충돌 여부
            boolean hit = false;
            if(visit[ny][nx]) {
                hit = true;
            }
            // 사과가 있는 경우
            if(arr[ny][nx] == 1) {
                // 충돌했으면 무조건 실패
                if(hit) return false;
                // 충돌없으면 머리 새로 늘리기
                visit[ny][nx] = true;
                snake.add(0, new Point(nx, ny));
                arr[ny][nx] = 0;
            }
            // 사과가 없는 경우
            else {
                Point tail = snake.get(snake.size() - 1);
                if(hit) {
                    // 헤드가 움직일 부분이 꼬리인 경우
                    if(tail.x == nx && tail.y == ny) {
                        // 문제 없음
                        // 꼬리 자르기
                        visit[tail.y][tail.x] = false;
                        snake.remove(snake.size() - 1);
                        // 새로운 머리 추가
                        visit[ny][nx] = true;
                        snake.add(0, new Point(nx, ny));
                    }
                    else {
                        return false;
                    }
                }
                else {
                    visit[tail.y][tail.x] = false;
                    snake.remove(snake.size() - 1);
                    visit[ny][nx] = true;
                    snake.add(0, new Point(nx, ny));
                }
            }
        }
        else {
            return false;
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
            time++;
            if(idx < count && ops[idx].len == time) {
                getDir(ops[idx].dir.charAt(0));
                idx++;
            }

        }

        System.out.println(time);


        br.close();
    }

}
