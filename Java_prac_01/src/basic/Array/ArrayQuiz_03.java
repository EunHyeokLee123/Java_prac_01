package basic.Array;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayQuiz_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kakao = {"무지", "네오", "어피치", "라이언", "춘식이"};
        System.out.println("현재 저장된 친구들: " + Arrays.toString(kakao));
        L1 : while(true){
            System.out.println("삭제할 이름을 알려주세요. ");
            String ans = sc.next();
            for (int i = 0; i < kakao.length; i++) {
                if(ans.equals(kakao[i])){
                    for (int j = i; j < kakao.length - 1; j++) {
                        String tmp = kakao[j+1];
                        kakao[j+1] = kakao[j];
                        kakao[j] = tmp;
                    }
                    String[] temp = new String[kakao.length-1];
                    //temp = Arrays.copyOf(kakao, kakao.length-1);
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = kakao[j];
                    }
                    kakao = temp; temp = null;
                    if(kakao.length == 0){
                        System.out.println("이제 배열에 아무것도 없습니다");
                        break L1;
                    }
                    System.out.println(Arrays.toString(kakao));
                    break;
                }
                else{
                    System.out.println("해당 이름은 배열에 없습니다.");
                    break;
                }
            }
        }
        sc.close();
    }
}
