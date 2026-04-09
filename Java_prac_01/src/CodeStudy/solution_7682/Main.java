package CodeStudy.solution_7682;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int x;
    static int o;

    // X와 O의 개수를 세고 가능한 경우인지 확인
    static boolean isValidCount(String line) {
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == 'X') {
                x++;
            }
            if(line.charAt(i) == 'O') {
                o++;
            }
        }

        return x == o || x  == o + 1;
    }

    static boolean isEnded(String line) {
        // x가 3개보다 적으면 무조건 불가능함.
        if(x < 3) {
            return false;
        }
        boolean xWin = false;
        boolean oWin = false;

        // 세로
        if(line.charAt(0) == line.charAt(3) && line.charAt(0) == line.charAt(6)) {
            if(line.charAt(0) == 'X') {
                xWin = true;
            }
            else if(line.charAt(0) == 'O') {
                oWin = true;
            }
        }

        if(line.charAt(1) == line.charAt(4) && line.charAt(1) == line.charAt(7)) {
            if(line.charAt(1) == 'X') {
                xWin = true;
            }
            else if(line.charAt(1) == 'O') {
                oWin = true;
            }
        }

        if(line.charAt(2) == line.charAt(5) && line.charAt(2) == line.charAt(8)) {
            if(line.charAt(2) == 'X') {
                xWin = true;
            }
            else if(line.charAt(2) == 'O') {
                oWin = true;
            }
        }
        // 가로
        if(line.charAt(0) == line.charAt(1) && line.charAt(0) == line.charAt(2)) {
            if(line.charAt(0) == 'X') {
                xWin = true;
            }
            else if(line.charAt(0) == 'O') {
                oWin = true;
            }
        }


        if(line.charAt(3) == line.charAt(4) && line.charAt(3) == line.charAt(5)) {
            if(line.charAt(3) == 'X') {
                xWin = true;
            }
            else if(line.charAt(3) == 'O') {
                oWin = true;
            }
        }

        if(line.charAt(6) == line.charAt(7) && line.charAt(6) == line.charAt(8)) {
            if(line.charAt(6) == 'X') {
                xWin = true;
            }
            else if(line.charAt(6) == 'O') {
                oWin = true;
            }
        }

        // 대각선
        if(line.charAt(0) == line.charAt(4) && line.charAt(0) == line.charAt(8)) {
            if(line.charAt(0) == 'X') {
                xWin = true;
            }
            else if(line.charAt(0) == 'O') {
                oWin = true;
            }
        }

        if(line.charAt(2) == line.charAt(4) && line.charAt(2) == line.charAt(6)) {
            if(line.charAt(2) == 'X') {
                xWin = true;
            }
            else if(line.charAt(2) == 'O') {
                oWin = true;
            }
        }

        // X가 이기는 경우
        if(x == o + 1) {
            if(x + o == 9 && !oWin) {
                return true;
            }
            else if(!oWin && xWin) {
                return true;
            }
            else {
                return false;
            }
        }
        // O가 이기는 경우
        if(x == o) {
            if(!xWin && oWin) {
                return true;
            } else return false;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if(line.equals("end")) {
                break;
            }
            x = 0;
            o = 0;
            if(isValidCount(line)) {
                if(isEnded(line)) {
                    sb.append("valid").append('\n');
                }
                else {
                    sb.append("invalid").append('\n');
                }
            }
            else {
                sb.append("invalid").append('\n');
            }

        }
        br.close();

        System.out.println(sb);

    }

}
