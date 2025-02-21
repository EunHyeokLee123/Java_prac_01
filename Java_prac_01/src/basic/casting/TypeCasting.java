package basic.casting;

public class TypeCasting {
    public static void main(String[] args) {
        byte b1 = 10;
        int i1 = b1;
        // int가 byte보다 큰 정수형이기에 업캐스팅이 자동으로 이루어짐.
        System.out.println(i1);
        int i2 = 45457457;
        //  byte b3 = i2;  에러, 다운캐스팅 필요
        byte b2 = (byte)i2;
        System.out.println(b2);

        // int가 char보다 범위가 더 크다. char는 숫자로는 int의 범위보다 작기에
        // int로 업캐스팅이 자동으로 이루어짐.
        char c1 = '가';
        int i3 = c1;
        System.out.println("i3 = " + i3);

        // 정수 int가 실수 double로 업캐스팅이 자동으로 이루어짐
        int i4 = 100;
        double d1 =i4;
        // 100이 실수인 100.0으로 표기됨.
        System.out.println("d1 = " + d1);
                /*
         - 크기가 작은 데이터 타입의 자료를 큰 데이터 타입으로 변환할 때는
          자바 가상 머신 (JVM)이 자동으로 타입을 올려서 변환해 줍니다.
          (promotion, UpCasting)
        */
    }
}

