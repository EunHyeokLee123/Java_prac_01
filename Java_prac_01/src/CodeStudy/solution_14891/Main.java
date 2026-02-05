package CodeStudy.solution_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> deq1;
    static List<Integer> deq2;
    static List<Integer> deq3;
    static List<Integer> deq4;


    static class Oper {
        int num;
        int flag;
        public Oper(int num, int flag) {
            this.num = num;
            this.flag = flag;
        }
    }

    static void move1(int flag) {
        if(flag == 1) {
            Integer last = deq1.get(7);
            deq1.remove(7);
            deq1.add(0, last);
        }
        else if(flag == -1) {
            Integer first = deq1.get(0);
            deq1.remove(0);
            deq1.add(deq1.size(), first);
        }
    }

    static void move2(int flag) {
        if(flag == 1) {
            Integer last = deq2.get(7);
            deq2.remove(7);
            deq2.add(0, last);
        }
        else if(flag == -1) {
            Integer first = deq2.get(0);
            deq2.remove(0);
            deq2.add(deq2.size(), first);
        }
    }

    static void move3(int flag) {
        if(flag == 1) {
            Integer last = deq3.get(7);
            deq3.remove(7);
            deq3.add(0, last);
        }
        else if(flag == -1) {
            Integer first = deq3.get(0);
            deq3.remove(0);
            deq3.add(deq3.size(), first);
        }
    }

    static void move4(int flag) {
        if(flag == 1) {
            Integer last = deq4.get(7);
            deq4.remove(7);
            deq4.add(0, last);
        }
        else if(flag == -1) {
            Integer first = deq4.get(0);
            deq4.remove(0);
            deq4.add(deq4.size(), first);
        }
    }

    static void getOneStep(Oper op) {
        if(op.num == 1) {
            move1(op.flag);
        }
        else if(op.num == 2) {
            move2(op.flag);
        }
        else if(op.num == 3) {
            move3(op.flag);
        }
        else {
            move4(op.flag);
        }
    }

    // num은 회전한 톱니
    // 회전한 톱니 영향으로 주변 톱니 회전 계산
    static int[] getTwoStep(Oper op) {
        boolean[] diff = isDiff();
        // 각 톱니의 회전 값
        // 0 안돔, 1 시계, -1 반시계
        int[] rot = new int[4];

        // 1이 도는 경우
        if(op.num == 1) {
            rot[0] = op.flag;
            // 1이랑 2가 다름
            if(diff[0]) {
                rot[1] = op.flag * -1;
                // 2랑 3이 다름
                if(diff[1]) {
                    rot[2] = op.flag;
                    // 3이랑 4랑 다름
                    if(diff[2]) {
                        rot[3] = op.flag * -1;
                    }
                }
            }
        }
        else if(op.num == 2) {
            rot[1] = op.flag;
            if(diff[0]) {
                rot[0] = op.flag * -1;
            }
            if(diff[1]) {
                rot[2] = op.flag * -1;
                if(diff[2]) {
                    rot[3] = op.flag;
                }
            }
        }
        else if(op.num == 3) {
            rot[2] = op.flag;
            if(diff[1]) {
                rot[1] = op.flag * -1;
                if(diff[0]) {
                    rot[0] = op.flag;
                }
            }
            if(diff[2]) {
                rot[3] = op.flag * -1;
            }
        }
        else {
            rot[3] = op.flag;
            if(diff[2]) {
                rot[2] = op.flag * -1;
                if(diff[1]) {
                    rot[1] = op.flag;
                    if(diff[0]) {
                        rot[0] = op.flag * -1;
                    }
                }
            }
        }
        return rot;
    }

    static void getThreeStep(int[] rot) {
        if(rot[0] != 0) {
            move1(rot[0]);
        }
        if(rot[1] != 0) {
            move2(rot[1]);
        }
        if(rot[2] != 0) {
            move3(rot[2]);
        }
        if(rot[3] != 0) {
            move4(rot[3]);
        }
    }

    // 1-2, 2-3, 3-4 의 다른지 여부
    // true면 다른것, false면 같은 것
    static boolean[] isDiff() {
        boolean[] result = new boolean[3];
        if(deq1.get(2) != deq2.get(6)) {
            result[0] = true;
        }
        if(deq2.get(2) != deq3.get(6)) {
            result[1] = true;
        }
        if(deq3.get(2) != deq4.get(6)) {
            result[2] = true;
        }
        return result;
    }

    static int getTotal() {
        int result = 0;
        if(deq1.get(0) == 1) {
            result += 1;
        }
        if(deq2.get(0) == 1) {
            result += 2;
        }
        if(deq3.get(0) == 1) {
            result += 4;
        }
        if(deq4.get(0) == 1) {
            result += 8;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        deq1 = new ArrayList<>();
        String s1 = br.readLine();
        for(int i = 0; i < 8; i++) {
            deq1.add(s1.charAt(i) - '0');
        }
        deq2 = new ArrayList<>();
        String s2 = br.readLine();
        for(int i = 0; i < 8; i++) {
            deq2.add(s2.charAt(i) - '0');
        }
        deq3 = new ArrayList<>();
        String s3 = br.readLine();
        for(int i = 0; i < 8; i++) {
            deq3.add(s3.charAt(i) - '0');
        }
        String s4 = br.readLine();
        deq4 = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            deq4.add(s4.charAt(i) - '0');
        }

        int count = Integer.parseInt(br.readLine());
        Oper[] ops = new Oper[count];

        StringTokenizer st;
        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ops[i] = new Oper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long result = 0;
        for(int i = 0; i < count; i++) {
            Oper now = ops[i];
            //getOneStep(now);
            int[] mid = getTwoStep(now);
            getThreeStep(mid);
        }
        result += getTotal();

        System.out.println(result);

        br.close();
    }

}
