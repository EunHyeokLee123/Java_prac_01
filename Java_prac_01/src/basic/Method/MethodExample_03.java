package basic.Method;

/*
# 반환값, 반환 유형 (return value, return type)

1. 반환값이란 메서드의 실행 결과값을 의미합니다.

2. 매개변수는 여러 개 존재할 수 있지만, 반환값은 오직 한 개만
 존재해야 합니다.

3. 전달되는 값의 타입을 반환 유형이라고 하며, 메서드를 선언할 때
 메서드 이름 앞에 반드시 반환 유형을 명시해야 합니다.

4. return이라는 키워드를 사용하며 return 뒤에 전달할 값을
 지정합니다. (변수, 상수)

5. 반환값이 있는 메서드는 호출문 자체가 하나의 값으로 처리될 수 있기 때문에
 반환값을 다른 변수에 대입할 수도 있고, 다른 메서드의 매개값으로도
 처리될 수 있습니다.

6. 모든 메서드가 반환값이 있는 것은 아닙니다. 메서드 실행 후에
 반환할 값이 딱히 없다면 return을 생략해도 됩니다.

7. 이 때는 반환유형을 메서드를 선언할 때 비워두지 마시고
 void라는 키워드를 작성해 주셔야 합니다.

8. 모든 메서드는 return을 만나면 강제로 메서드가 종료됩니다.
 따라서 조건 없이 return문 아래에 코드를 작성할 수 없습니다.
 void메서드에서는 return 키워드를 탈출 기능으로 사용할 수 있습니다.

*/

public class MethodExample_03 {

    static int add (int n1, int n2){
        return n1+ n2;
    }

    // 배열을 리턴타입으로 할 수 있다.
    static int[] operateTotal(int n1, int n2){
        int[] result = new int[4];
        result[0] = n1 + n2;
        result[1] = n1 - n2;
        result[2] = n1 * n2;
        result[3] = n1 / n2;

        return result;
    }

     /*
         - 반환값이 없는 void 타입의 메서드는 값이 돌아오지 않기 때문에
          실행 결과를 변수에 저장할 수 없고, 다른 메서드의 매개값으로도
          사용이 불가능합니다.
         - 반드시 단독 호출하여 사용해야 합니다.
         - void 메서드는 단순히 동작을 지시하는 역할을 수행합니다.
         */

    // 아무것도 리턴하지 않는 경우 void로 리턴타입 선언
    static void divide(int n1, int n2){
        int result;
        if(n2 !=0) {
            result = n1 / n2;
            System.out.printf("%d / %d = %d \n", n1, n2, result);
        }
        else {
            System.out.println("0으로는 못 나눕니다.");
        }
    }

    public static void main(String[] args) {

        int r1 = add(3, 6);
        int r2 = add(15, 67);
        int r3 = add(add(4,8), add(6,88));
        int[] arr = operateTotal(41251, 123);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println("=================");
        int a1 = 71; int a2 = 55;
        divide(a1, a2);
        System.out.printf("a1 = %d, a2 = %d \n", a1, a2);
    }
}
