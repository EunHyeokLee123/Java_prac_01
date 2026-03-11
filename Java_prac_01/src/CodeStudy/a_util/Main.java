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
                "426332202600005", "411320202600011", "426333202600012",
                "427343202600024", "427514202600028", "427514202600035", "431369202600010",
                "431369202600018", "428351202600034", "441391202600027",
                "441391202600074", "443440202600020", "443443202600030",
                "448540202600014", "428352202600014",  "411305202600014", "411305202600026",
                "427347202600074", "447502202600063", "442418202600024",
                "442420202600049", "428352202600013", "443571202600092", "411305202600027",
                "411302202600021", "411310202600012", "411306202600043", "411303202600005",
                "411304202600011", "441374202600049", "443571202600117",
                "428349202600064", "428351202600048", "430367202600080",
                "411303202600007", "427343202600058", "448533202600029", "429360202600019");

        for(String s : list) {
            set.add(s);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(!set.add(s)) {
                System.out.println(i + ", " + s + " 는 중복");
            }
            i++;
        }

        System.out.println("종료");

        br.close();

    }

}
