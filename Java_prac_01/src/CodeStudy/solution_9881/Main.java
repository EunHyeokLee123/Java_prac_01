package CodeStudy.solution_9881;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        if(list.size() == 1) {
            System.out.println(0);
        }
        else {
            list.sort((a, b) -> a - b);
            int result = 0;
            while (true) {
                if (list.get(list.size() - 1) - list.get(0) <= 17) {
                    break;
                }
                int diff = list.get(list.size() - 1) - list.get(0);
                result += 2 * (diff/ 2) * (diff / 2);
            }
            System.out.println(result);
        }


        br.close();
    }

}
