package basic.Operator;

public class AssignmentOperator {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;

        // 산술할당연산자

        b =+ 3; // b = +3; -> 이건 대입 연산이 아니에요!!! 순서 잘 지키기
        System.out.println(b);

        a += 3; //a = a + 3 -> 기존의 a에 3을 더한 값을 새롭게 대입하겠다.
        System.out.println(a);

        System.out.println("---------------------------");

        a -= 4; //4 -> 기존의 a에 4를 뺀 값을 대입해서 저장하겠다.
        System.out.println(a);

        a *= 6; //24 -> 기존의 a에 6를 곱한 값을 대입해서 저장하겠다.
        System.out.println(a);

        a /= 5; //4 -> 기존의 a를 5로 나누고 그 몫을 대입해서 저장하겠다.
        System.out.println(a);

        a %= 3; //1 -> 기존의 a를 3으로 나누고 그 나머지를 대입해서 저장하겠다.
        System.out.println(a);
    }
}
