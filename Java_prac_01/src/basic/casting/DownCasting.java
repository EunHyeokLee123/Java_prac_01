package basic.casting;

public class DownCasting {
    public static void main(String[] args) {

        /*
         - 크기가 큰 데이터 타입의 값을 작은 데이터 타입으로 변환하려면
          반드시 형 변환 연산자: (type)를 사용하여 명시적으로
          형 변환을 진행해 주셔야 합니다. (DownCasting)

         - 명시적으로 형 변환을 해야 하는 이유는, DownCasting의 경우
          저장 공간이 줄어들어 데이터 손실의 가능성이 항상 존재하기 때문입니다.
          (overflow, underflow)
         */

        int i1 = 72;
        // int가 char보다 큰 타입이기에 구문 오류 일어남.
        //  char c1 = i1;
        // 다운캐스팅을 위해 강제 형 변환
        char c1 = (char) i1;
        System.out.println("c1 = " + c1);

        double d1 = 4.77;
        // double이 int보다 큰 타입이라 구문 오류
        // int i2 = d1;
        int i2 = (int) d1;
        // 소수점 아래 숫자 버려서 정수인 4가 됨.
        System.out.println("i2 = " + i2);

        // 값이 지나치게 훼손이 되는 다운캐스팅
        int i3 = 1000;
        byte b1 = (byte) i3;
        System.out.println("b1 = " + b1);
    }
}
