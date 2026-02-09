package CodeStudy.a_util;

import oop.modi.cls.pac1.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        // 글을 작성할 때마다, 여기에 넣는다.
        List<String> list = List.of("411300202600013", "411305202600015", "411306202600005",
                "411309202600002", "411310202600013", "411312202600013", "426333202600024",
                "426332202600005", "411320202600011", "426333202600012");

        for(String s : list) {
            set.add(s);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(!set.add(s)) {
                System.out.println(i);
            }
            i++;
        }

        System.out.println("종료");

        br.close();

    }

}
