package CodeStudy.solution_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int card = Integer.parseInt(st.nextToken());
        int play = Integer.parseInt(st.nextToken());

        ArrayList<Long> cardList = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < card; i++) {
            cardList.add(Long.parseLong(st1.nextToken()));
        }
        cardList.sort(Comparator.naturalOrder());

        for (int i = 0; i < play; i++) {
            Long temp = cardList.get(0) + cardList.get(1);
            cardList.set(0, temp);
            cardList.set(1, temp);
            cardList.sort(Comparator.naturalOrder());
        }

        Long sum = 0L;
        for (Long i : cardList) {
            sum += i;
        }
        System.out.println(sum);

        br.close();
    }

}
