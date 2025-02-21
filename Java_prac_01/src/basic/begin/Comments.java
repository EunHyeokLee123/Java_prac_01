package basic.begin;

public class Comments {
    public static void main(String[] args) {
        // 주석은 이거야
        System.out.println("이게 뭘까나");
        String ab = "안녕하세요";
        System.out.println(ab);
        /*
         # 변수 (Variable)

         1. 변수는 데이터가 저장되는 공간에 이름을 붙여놓은 것입니다.
         2. 변수는 생성할 때 변수에 저장되는 데이터의 크기와 모양에 따라
         적당한 데이터 타입을 선언해야 합니다.
         ex) int: 4바이트의 정수, String: 문자열(문장)
         3. 변수는 동일한 이름으로 중복 선언할 수 없습니다.
         4. 변수 내부의 값은 언제든지 변경이 가능합니다.
         */

        int a = 10;
        System.out.println(a);
        a= 30;
        int b= 10;
        System.out.println("a 값은 " + a);
        
    }
}
