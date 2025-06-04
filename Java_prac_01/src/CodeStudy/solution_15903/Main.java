package CodeStudy.solution_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static int[] findTwo(int[] arr){
        int first = 0;
        int second = 1;
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] < arr[first]){
                second = first;
                first = i;
            }
            else if(arr[i] < arr[second]){
                second = i;
            }
        }
        return new int[]{first, second};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int card = Integer.parseInt(st.nextToken());
        int play = Integer.parseInt(st.nextToken());

        int[] cardList = new int[card];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < card; i++) {
            cardList[i] = Integer.parseInt(st1.nextToken());
        }

        for (int i = 0; i < play; i++) {
            int[] tmp = findTwo(cardList);
            int plusMin = cardList[tmp[0]] + cardList[tmp[1]];
            System.out.printf("%d, %d, %d \n", cardList[tmp[0]], cardList[tmp[1]], plusMin);
            cardList[tmp[0]] = plusMin;
            cardList[tmp[1]] = plusMin;
        }

        Long sum = 0L;
        for (int i = 0; i < cardList.length; i++) {
            sum += cardList[i];
        }

        System.out.println(sum);

        br.close();
    }

}
