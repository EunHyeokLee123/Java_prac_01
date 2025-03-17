package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class solution_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String line = br.readLine();
        
        HashMap<Character, Integer> elect = new HashMap<>();

        for (char c : line.toCharArray()) {
            // getOrDefault는 key에 맵핑된 값을 가져오는데, 만약 key가 존재하지 않으면 
            // 지정한 기본값이 세팅되고 리턴됨.
            // null 방지
            elect.put(c, elect.getOrDefault(c, 0) + 1);
        }
        int max = 0; char pre = '\0';
        for (Character c : elect.keySet()) {
            int temp = elect.get(c);
            if(temp > max) {
                max = temp;
                pre = c;
            }
        }
        System.out.println(pre);

        br.close();
    }
}
