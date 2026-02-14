package CodeStudy.solution_20055;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int K;
    // 현재 벨트 내구도 상태
    static List<Integer> arr;
    static int[] locate;
    static int count = 1;

    // 벨트랑 로봇 회전
    static void rotate() {
        // 벨트 이동
        int last  = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        arr.add(0, last);

        // 로봇이동
        // 뒤에서부터 확인하자
        for(int i = N - 1; i > 0; i--) {
            locate[i] = locate[i - 1];
        }
        locate[N - 1] = -1;

        locate[0] = -1;
    }

    // 로봇 이동
    static void moveRobot() {
        for(int i = N - 2; i >= 0; i--) {
            // 이동가능한 조건
            if(locate[i] != -1 && locate[i + 1] == -1 &&
            arr.get(i + 1) > 0) {
                locate[i + 1] = locate[i];
                locate[i] = -1;
                arr.set(i + 1, arr.get(i + 1) - 1);
            }
        }
        locate[N - 1] = -1;
    }

    // 종료 여부 판단
    static boolean isQuit() {
        int temp = 0;
        for(int i = 0; i < 2 * N; i++) {
            if(arr.get(i) == 0) {
                temp++;
            }
        }
        if(temp >= K) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        locate = new int[2 * N];
        arr = new ArrayList<>();
        // 로봇이 올라가있지 않으면 -1임.
        for(int i = 0; i < 2 * N; i++) {
            locate[i] = -1;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 2 * N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int result = 1;
        while(true) {
            // 벨트랑 로봇 회전
            rotate();
            // 로봇 옮기기
            moveRobot();
            // 로봇 올리기
            // 만일 첫칸이 비어있고, 내구도가 1 이상이라면
            if(arr.get(0) > 0 && locate[0] == -1) {
                arr.set(0, arr.get(0) - 1);
                locate[0] = count;
                count++;
            }
            // 종료 여부 판단
            if(isQuit()){
                break;
            }
            result++;
        }

        System.out.println(result);

        br.close();
    }

}
