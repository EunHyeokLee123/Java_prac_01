package CodeStudy.solution_17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1};
    // height
    static int H;
    // width
    static int W;
    // 연료값의 정보를 담을 곳
    static int[][] arr;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Queue에 담길 배열은 길이가 4임.
        // y, x, direction, price
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < W; i++) {
            int[] temp = new int[4];
            temp[0] = 0;
            temp[1] = i;
            // 시작점이라서 방향값이 없음
            temp[2] = -1;
            temp[3] = arr[0][i];
            queue.offer(temp);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] temp = queue.poll();
                // 끝에 다다른 경우
                if(temp[0] == H - 1) {
                    if(MIN > temp[3]) {
                        MIN = temp[3];
                    }
                }
                else {
                    for(int i = 0; i < 3; i++) {
                        // 이전 방향과 다른지 확인
                        if(temp[2] != i) {
                            int nx = temp[1] + dx[i];
                            int ny = temp[0] + 1;
                            // 인덱스 유효 확인
                            if(nx < W && nx >= 0 && ny < H && ny >= 0) {
                                int[] next = new int[4];
                                next[0] = ny;
                                next[1] = nx;
                                next[2] = i;
                                next[3] = temp[3] + arr[ny][nx];
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(MIN);

        br.close();
    }

}
