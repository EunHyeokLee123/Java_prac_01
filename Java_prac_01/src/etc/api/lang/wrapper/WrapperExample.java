package etc.api.lang.wrapper;

public class WrapperExample {
    public static void main(String[] args) {
        
        // 기본 데이터 타입으로 선언된 변수들
        int a = 500;
        boolean b = false;
        char c = 'A';
        double d = 3.14;
        
        // boxing : 기본 데이터 타입을 객체 타입으로 변환
        // Integer a2 = new Integer(a);
        // Boolean b1 = new Boolean(b);

        // autoboxing : 기본 타입을 자동으로 객체형으로 변환
        Integer a1 = 1000;
        Boolean b1 = b;
        Character c1 = c;
        Double d1 = d;

        // unboxing : 객체 타입으로 포장된 값을 기본 데이터 타입으로 풀어내는 과정
        int ii = a1.intValue();  // ==> 더 이상 사용하지 않는 문법
        int i2 = a1;
        double dd = d1;
    }
}
