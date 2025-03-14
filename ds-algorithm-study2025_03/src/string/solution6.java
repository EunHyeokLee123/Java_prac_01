package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String tar = sc.next();
        // input에 있는 target의 인덱스를 담을 리스트
        // 타겟의 개수를 모르기에 배열 대신 리스트 사용
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == tar.charAt(0))
                index.add(i);
        }
        // 정답을 담을 배열
        int[] distance = new int[input.length()];
        
        for (int i = 0; i < input.length(); i++) {
            // 초기 거리의 최소값은 문장의 길이로 함. 불가능한 값임.
            int min = input.length();
            for (int j = 0; j < index.size(); j++) {
                // 타겟의 인덱스들과 현재 인덱스 i의 절대값(거리)을 구함.
                int tmp = Math.abs(index.get(j) - i);
                // 거리 최소값 최신화
                min = Math.min(min, tmp);
            }
            // 최신화가 끝난 최소값을 정답 배열에 삽입
            distance[i] = Math.abs(min);
        }

        // 형식에 맞춰 출력
        for (int i : distance) {
            System.out.printf("%d ", i);
        }
        sc.close();
    }

}
