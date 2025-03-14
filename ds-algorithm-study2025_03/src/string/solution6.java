package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solution6 {

    public static void main(String[] args) throws IOException {

        // Scanner는 정규표현식을 처리하는 등 기능이 많음 -> 입력이 많으면 속도가 저하됨.
        // BufferedReader는 단순히 입력값을 읽어오는 것이기에 속도가 빠름.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄을 입력
        String sr = br.readLine();
        // 구분자를 기준으로 구분됨.
        StringTokenizer st = new StringTokenizer(sr, " ");

        String input = st.nextToken();
        String tar = st.nextToken();

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

    }

}
