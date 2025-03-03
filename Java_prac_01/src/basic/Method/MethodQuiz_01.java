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

// 특정 요소가 배열에 포함되어 있는지의 여부를 확인하는 메서드를 작성하세요.
    static boolean isInclude(String searchTarget) {
        // 리턴 자체에 조건문을 넣어 코드를 간소화할 수 있음.
        return indexOf(searchTarget) != -1;
    }



    // foods 배열에 데이터를 끝에 추가하는 메서드를 작성하세요.
    static void push(String newFood) {
        String[] temp = makeArrays(1);
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[temp.length - 1] = newFood;
        foods = temp;
        // 지역변수라서 굳이 null할 필요 없다
        temp = null;
    }


    // 특정 인덱스가 범위 내의 올바른 인덱스인지를 확인하는 메서드를 작성하세요.
    // 작성이 완료되면 타 메서드에서 활용할 수 있을 것입니다.
    static boolean isOutOfBounds(int targetIndex) {
        if(targetIndex < 0 || targetIndex > foods.length - 1){
            return true ;
        }
        else
            return  false;
    }


    // 원하는 인덱스 위치에 요소를 삽입하는 메서드를 작성하세요.
    // targetIndex는 기존 foods의 배열 인덱스 범위 내여야 합니다.
    static void insert(int targetIndex, String newFoodName) {
        if(isOutOfBounds(targetIndex)){
            System.out.println("유효하지 않은 인덱스입니다.");
            return;
        }
        String[] temp = makeArrays(1);
        for (int i = 0; i < targetIndex; i++) {
            temp[i] = foods[i];
        }
        temp[targetIndex] = newFoodName;
        for (int i = targetIndex + 1; i < temp.length; i++) {
            temp[i] = foods[i-1];
        }
        foods = temp; temp = null;
    }


    // 원하는 인덱스 위치의 요소를 수정하는 메서드를 작성하세요.
    // targetIndex는 기존 foods의 배열 인덱스 범위 내여야 합니다.

    static void modify(int targetIndex, String newFoodName) {
        if(isOutOfBounds(targetIndex)){
            System.out.println("유효하지 않은 인덱스입니다.");
            return;
        }
        foods[targetIndex] = newFoodName;
    }

    // 특정 인덱스의 요소를 삭제하는 메서드를 작성하세요.

    static void remove(String deleteTarget) {
        if(!isInclude(deleteTarget)){
            System.out.println(deleteTarget+"은 배열에 없습니다.");
            return;
        }
        int idx = indexOf(deleteTarget);
        foods[idx] = null;
        for (int i = idx; i < foods.length - 1; i++) {
            String tmp = foods[i];
            foods[i] = foods[i+1];
            foods[i+1] = tmp;
        }
        String[] temp = new String[foods.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = foods[i];
        }
        foods = temp; temp = null;
    }

    // 배열 내부를 깔끔하게 비워버리는 메서드를 작성하세요. (삭제 반복 x)

    static void clear(){
        String[] str = new String[0];
        foods = str;
    }

    private static String[] makeArrays(int size) {
        String[] temp = new String[foods.length + size];
        return temp;
    }

    public static void main(String[] args) {
        printfoods(foods);
        int a1 = indexOf("pork");
        System.out.println("a1 = " + a1);
        remove("beef");
        System.out.println(Arrays.toString(foods));
    }

}
