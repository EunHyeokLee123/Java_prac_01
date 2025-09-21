package CodeStudy.solution_2885;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // 1. 필요한 최소 총 길이를 먼저 구하자
        int first = 1;
        
        // 필요한 최소 초콜릿 개수 구하기
        while (first < target) {
            first *= 2;
        }

        int result1 = first;
        int result2 = 0;
        
        // 나누는 횟수 구하기
        while (target > 0) {
            // 빼려고 하는 막대의 크기가 남은 target 크기보다 큰 경우
            // 남은 막대를 한번 더 나눠야 함.
            if(first > target) {
                // 반절로
                first /= 2;
                // 나누기 횟수 늘림
                result2++;
                continue;
            }
            // 종료 조건
            if(target == first) {
                break;
            }
            // 남은 target의 길이를 빼줘야 함.
            target -= first;
        }

        System.out.printf("%d %d",result1, result2);

        sc.close();
    }

}
