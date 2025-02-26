package basic.Method;

/*
    # 매개 변수 (parameter, argument)

    1. 매개변수는 메서드를 호출할 때, 메서드 실행에 필요한 값들을
     메서드 내부로 전달하는 매개체 역할을 합니다.

    2. 메서드 호출부에서 어떤 매개값을 전달하느냐에 따라
     메서드의 실행 결과는 달라질 수 있습니다.

    3. 매개값을 몇 개 받아서 사용할지는 메서드를 선언할 때 선언부에서
     ()안에 미리 개수와 타입을 지정합니다.

    4. 매개변수의 이름을 지을 때는 호출자가 선언부로 돌아와서
    매개값을 확인하지 않게, 어떠한 값을 담는 변수인지
    그 뜻을 알기 쉽게 지어주면 서로에게 좋습니다.

    5. 매개변수를 하나도 선언하지 않을 수도 있습니다. 이 때는 메서드의 선언부에
     () 내부를 비워둡니다. 그리고 호출할 때도 ()를 비워서 호출합니다.
*/

public class MethodExample_02 {

    static int calcTotal(int start, int end){
        int result = 0;
        for (int i = start; i <= end ; i++) {
            result += i;
        }
        return result;
    }

    // 매개변수가 없는 경우
    static int GiveNum(){
        double rn = Math.random();
        if(rn > 0.33){
            return 33;
        }
        else if(rn > 0.66){
            return 66;
        }
        else{
            return 0;
        }
    }

    // 배열을 input으로 받는 경우
    static double CalArray(int[] arr){
        double result = 0.0;
        for (int i : arr) {
            result += i;
        }
        return result/arr.length;
    }

    // 정수 n개를 전달하면 그 평균을 리턴하는 메소드
    // n개의 정수를 하나의 배열로 자동으로 묶어줌
    static double CalAverage(int... num){
        double result = 0.0;
        for (int i : num) {
            result += i;
        }
        return result/num.length;
    }



    public static void main(String[] args) {
        int re = calcTotal(4, 104);
        System.out.printf("4 ~ 104까지의 합은 %d \n", re);
        int re2 = GiveNum();
        int[] arr = {1,2,3,4,5,56,6,6,6,6,6,23423,42,34,234,23,4};
        double re3 = CalArray(arr);
        System.out.printf("%.1f \n", re3);
    }
}
