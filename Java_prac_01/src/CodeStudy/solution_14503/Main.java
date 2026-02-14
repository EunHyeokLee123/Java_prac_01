package CodeStudy.solution_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int flag;
    static int[] now;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void getNextWay() {
        // 북, 동, 남, 서
        if(flag == 0) {
            flag = 3;
        }
        else if(flag == 1) {
            flag = 0;
        }
        else if(flag == 2) {
            flag = 1;
        }
        else {
            flag = 2;
        }
    }

    static int[] getBack(int[] now) {
        if(flag == 0) {
            return new int[] {now[0] + 1, now[1]};
        }
        else if(flag == 1) {
            return new int[] {now[0], now[1] - 1};
        }
        else if(flag == 2) {
            return new int[] {now[0] - 1, now[1]};
        }
        else {
            return new int[] {now[0], now[1] + 1};
        }
    }

    static int[] getFront(int[] now) {
        if(flag == 0) {
            return new int[] {now[0] - 1, now[1]};
        }
        else if(flag == 1) {
            return new int[] {now[0], now[1] + 1};
        }
        else if(flag == 2) {
            return new int[] {now[0] + 1, now[1]};
        }
        else {
            return new int[] {now[0], now[1] - 1};
        }
    }

    // 0 청소전, 1 벽, 2 청소됨
    static int BFS() {
        int count = 0;
        while(true) {
            // 이동한 현재 칸 청소
            if(arr[now[0]][now[1]] == 0) {
                count++;
                arr[now[0]][now[1]] = 2;
            }
            // 주변 4칸 중 청소할 칸이 있는지 여부
            boolean exist = false;
            for(int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if(arr[ny][nx] == 0) {
                        exist = true;
                    }
                }
            }
            // 청소할 칸이 있는 경우
            if(exist) {
                while(true) {
                    getNextWay();
                    // 앞에 보기
                    int[] front = getFront(now);
                    // 유효인덱스 확인
                    if(front[0] >= 0 && front[1] >= 0 && front[0] < N && front[1] < M) {
                        // 앞이 청소할 곳인지 확인
                        if(arr[front[0]][front[1]] == 0) {
                            // 앞으로 이동
                            now = front;
                            break;
                        }
                    }
                }
            }
            // 청소할 칸이 없는 경우
            else {
                int[] temp = getBack(now);
                if(temp[0] >= 0 && temp[0] < N && temp[1] >= 0 && temp[1] < M) {
                    // 뒤로 갈곳이 벽인 경우
                    if(arr[temp[0]][temp[1]] == 1) {
                        break;
                    }
                    now = temp;
                }
                // 후진이 불가능한 경우
                else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        // y, x
        now = new int[2];
        for(int i = 0; i < 2; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }
        flag = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS());

        br.close();
    }

}
