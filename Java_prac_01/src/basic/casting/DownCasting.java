package basic.casting;

public class DownCasting {
    public static void main(String[] args) {
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
