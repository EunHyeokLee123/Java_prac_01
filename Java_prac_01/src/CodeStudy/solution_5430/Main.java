package CodeStudy.solution_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Result {
        boolean reverse;
        List<Integer> list;
        boolean error;
        public Result(boolean reverse, List<Integer> list, boolean error) {
            this.reverse = reverse;
            this.list = list;
            this.error = error;
        }
    }

    // 입력받은 숫자 배열을 array로 변환하는 메소드
    static List<Integer> convertToArray(String input, int length) {
        List<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }
    
    // R은 뒤집기, D는 맨앞자리 버리기
    static Result doThing(String order, List<Integer> input) {
        boolean reverse = false;
        for (int i = 0; i < order.length(); i++) {
            if(order.charAt(i) == 'R') {
                reverse = !reverse;
            }
            // 지우는 경우
            else {
                // 아이템이 없는데 지우는 경우
                if(input.isEmpty()) {
                    // 에러로 리턴
                    return new Result(false, null, true);
                }
                // 현재 뒤집혀진 상태인 경우
                if(reverse) {
                    input.remove(input.size() - 1);
                }
                else {
                    input.remove(0);
                }
            }
        }
        return new Result(reverse, input, false);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String order = br.readLine();
            int length = Integer.parseInt(br.readLine());
            List<Integer> input = convertToArray(br.readLine(), length);
            Result result = doThing(order, input);
            if(result.error) {
                System.out.println("error");
            }
            else {
                if (result.list.isEmpty()) {
                    System.out.println("[]");
                }
                else {
                    StringBuilder sb = new StringBuilder("");
                    sb.append("[");
                    // 뒤집어서 출력해야 하는 경우
                    if (result.reverse) {
                        for (int j = result.list.size() - 1; j > 0; j--) {
                            sb.append(result.list.get(j));
                            sb.append(",");
                        }
                        sb.append(result.list.get(0));
                    }
                    // 원래 순서로 출력해야 하는 경우
                    else {
                        for (int j = 0; j < result.list.size() - 1; j++) {
                            sb.append(result.list.get(j));
                            sb.append(",");
                        }
                        sb.append(result.list.get(result.list.size() - 1));
                    }
                    sb.append("]");
                    System.out.println(sb.toString());
                }
            }
        }



        br.close();
    }

}
