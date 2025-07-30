package CodeStudy.solution_7561;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    // 고윳값 계산기
    public static long calDeter(List<Integer> arr) {
        long result = 0L;
        result += arr.get(0) * (arr.get(4) * arr.get(8) - arr.get(5) * arr.get(7));
        result -= arr.get(1) * (arr.get(3) * arr.get(8) - arr.get(5) * arr.get(6));
        result += arr.get(2) * (arr.get(3) * arr.get(7) - arr.get(4) * arr.get(6));

        return result;
    }

    // 소수점 변환기
    public static String makeDouble(long a1, long a2) {
        double result = (double)a1 / a2;
        if(result < 0.0005 && result > -0.0005) {
            return String.format("%.3f", 0.0);
        }
        return String.format("%.3f", result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Long> result = new ArrayList<>();
        // 전체 반복 횟수
        for (int i = 0; i < N; i++) {
            // 한 케이스당 3줄 입력 받음
            for (int y = 0; y < 3; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int x = 0; x < 3; x++) {
                    arr.add(Integer.parseInt(st.nextToken()));
                }
                b.add(Integer.parseInt(st.nextToken()));
            }
            // A의 행렬값
            long totalDeter = calDeter(arr);
            // A1, A2, A3의 행렬값 삽입
            for (int j = 0; j < 3; j++) {
                List<Integer> sub = new ArrayList<>(List.copyOf(arr));
                for (int k = 0; k < 3; k++) {
                    sub.set(j + k * 3, b.get(k));
                }
                result.add(calDeter(sub));
            }

            for (Long re : result) {
                System.out.printf("%d ", re);
            }
            System.out.printf("%d", totalDeter);
            System.out.println();
            if (totalDeter == 0) {
                System.out.println("No unique solution");
            } else {
                System.out.printf("Unique solution: ");
                for (long v : result) {
                    String s = makeDouble(v, totalDeter);
                    System.out.printf("%s ", s);
                }
                System.out.println();
            }
            System.out.println();
            arr.clear();
            b.clear();
            result.clear();
        }

        br.close();
    }

}
