package CodeStudy.solution_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void leftArm() {
        int count = 0;
        for(int i = heart.x - 1; i >= 0; i--) {
            if(arr[heart.y].charAt(i) == '*') {
                count++;
            }
            else {
                break;
            }
        }
        result[0] = count;
    }

    static void rightArm() {
        int count = 0;
        for(int i = heart.x + 1; i < length; i++) {
            if(arr[heart.y].charAt(i) == '*') {
                count++;
            }
            else {
                break;
            }
        }
        result[1] = count;
    }

    static void leftLeg() {
        int count = 0;
        for(int i = wa.y + 1; i < length; i++) {
            if(arr[i].charAt(wa.x - 1) == '*') {
                count++;
            }
            else {
                break;
            }
        }
        result[3] = count;
    }

    static void rightLeg() {
        int count = 0;
        for(int i = wa.y + 1; i < length; i++) {
            if(arr[i].charAt(wa.x + 1) == '*') {
                count++;
            }
            else {
                break;
            }
        }
        result[4] = count;
    }

    static void waist() {
        int count = 0;
        for(int i = heart.y + 1; i < length; i++) {
            if(arr[i].charAt(heart.x) == '*') {
                count++;
            }
            else {
                // 허리 마지막 점 데이터 넣기
                wa = new Point(heart.x, i - 1);
                break;
            }
        }
        result[2] = count;
    }

    static int length;
    static String[] arr;
    // 머리
    static Point head;
    // 심장
    static Point heart;
    // 허리
    static Point wa;
    // 출력물 담기
    // 왼팔, 오른팔, 허리, 왼다리, 오른다리
    static int[] result = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = br.readLine();
        }

        int fl = 0;
        // 머리 먼저 찾기
        boolean flag = false;
        while(true) {
            for(int i = 0; i < length; i++) {
                if(arr[fl].charAt(i) == '*') {
                    head = new Point(i, fl);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            fl++;
        }

        heart = new Point(head.x, head.y + 1);
        // 왼팔, 오른팔, 허리, 왼다리, 오른다리 길이 찾기
        leftArm();
        rightArm();
        waist();
        leftLeg();
        rightLeg();

        StringBuilder sb = new StringBuilder("");
        sb.append(heart.y + 1).append(" ").append(heart.x + 1).append("\n");
        for(int i = 0; i < 5; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
