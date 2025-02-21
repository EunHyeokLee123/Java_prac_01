package basic.Operator;

public class LogicalOperator {
    public static void main(String[] args) {
        // 비교 연산자 (<, <=, >, >=, ==, !=)
        // 좌항과 우항의 크기를 비교하여, 결과값으로
        // 항상 논리형 타입의 값을 도출합니다.
        int x=10; int y=20;
        System.out.println(x != y);
        System.out.println(x>y);

        /*
             # 논리 연산자 (&, &&, |, ||)
             - 좌항과 우항의 논리값을 연산하여 하나의 논리값을 도출합니다.
             1. &, &&: 양쪽 항의 논리값이 모두 true일 경우에만 true가 도출됩니다.
             2. |, ||: 양쪽 항의 논리값 중 한 쪽만 true여도 true를 도출합니다.
             &&, || -> 단축 평가 연산 (short circuit operation)
             - 좌항의 연산 결과가 전체 연산 결과에 영향을 미칠 경우
              우항의 연산을 진행하지 않습니다.
        */
        // AND 둘 다 true여야 true
        boolean re1 = (x>8)&&(y>15);
        System.out.println(re1);
        // OR 하나라도 true면 true
        boolean re2 = (x>15)||(y<25);
        System.out.println(re2);

        // 우항에서 에러 발생
        System.out.println(x>10 & (y/0==10));
        // 우항 연산 실행X, 에러 발생 X
        System.out.println(x>10 && (y/0==10));

    }
}
