package CodeStudy.solution_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class AlphaNum {
        char alpha;
        int num;
        public AlphaNum(char alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(br.readLine().toCharArray());
        }
        // 영어 대문자로 구성된 각 자릿수의 최대값을 저장하려고 하는 배열
        int[] arr = new int[26];
        for (char[] chars : list) {
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                // 등장한 자리수에 맞게 가중치 값 갱신
                arr[chars[i] - 'A'] += (int) Math.pow(10, length - i - 1);
            }
        }

        List<AlphaNum> tri = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            // 가중치가 0이 아닌 얘들만 list에 넣음
            if (arr[i] > 0) {
                char temp = (char) ('A' + i);
                tri.add(new AlphaNum(temp, arr[i]));
            }
        }
        
        // 오름차순
        tri.sort((a, b) -> b.num - a.num);

        long result = 0;
        // 가중치에 할당된 순서값을 곱해서 전체에 더해주면 결과값이 나옴.
        for (int i = 0; i < tri.size(); i++) {
            result += tri.get(i).num * (9 - i);
        }

        System.out.println(result);

        br.close();
    }

}
