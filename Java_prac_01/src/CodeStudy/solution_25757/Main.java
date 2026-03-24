package CodeStudy.solution_25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int getNum(String input) {
        if(input.equals("F")) {
            return 3;
        }
        if(input.equals("Y")) {
            return 2;
        }
        if(input.equals("O")) {
            return 4;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        String kind = st.nextToken();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(br.readLine());
        }
        int max = getNum(kind);

        System.out.println(set.size() / (max - 1));


        br.close();
    }

}
