package basic.Method;

import java.util.Arrays;
import java.util.Scanner;

public class MethodQuiz_01 {

    static String[] foods = {"chicken", "pasta", "beef"};

    // 배열 내부를 한눈에 보기
    static void printfoods(String[] arr){
        System.out.println(Arrays.toString(arr));
    }

    // foods 배열에서 특정 데이터의 인덱스를 리턴
    static int indexOf(String name){
        int result = -1;
        for (int i = 0; i < foods.length; i++) {
            if(name.equals(foods[i]))
                result = i;
        }
        return result;
    }



    public static void main(String[] args) {
        printfoods(foods);
        int a1 = indexOf("pork");
        System.out.println("a1 = " + a1);
    }

}
