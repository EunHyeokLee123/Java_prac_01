package basic.datatype;

public class FloatExample {
    public static void main(String[] args) {
        /*
        * 기본 실수 리터럴이 double이라서
        * f를 붙여야 float로 할당이 가능하다.*/
        float ab  = 7.12345f;
        double cd = -0.124_125_135_135;

        // float의 크기로 인해 반올림을 해서
        // 소수점 7번째까지 표현함.
        float f1 = 1.23456781234F;
        double d1 =1.23456781234;

        System.out.println("f1 = " + f1);
        System.out.println("d1 = " + d1);
    }
}
