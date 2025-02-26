package basic.Array;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayQuiz_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] foods = new String[0];
        int len = 0;
        L1 : while(true){
            System.out.println("음식명을 입력하시오. ");
            String tmp = sc.next();
            if(tmp.equals("그만")){
                System.out.println("그만 입력할게요.");
                break L1;
            }
            else{
                len++;
                String[] temp = new String[len];
                for (int i = 0; i < foods.length; i++) {
                        temp[i] = foods[i];
                }
                temp[len-1] = tmp;
                foods = temp; temp =null;
            }
        }

        System.out.println(Arrays.toString(foods));
        sc.close();
    }
}
