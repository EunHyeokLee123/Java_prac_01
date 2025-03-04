package etc.exception.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        try {
            System.out.println("정수 입력: ");
            int num = sc.nextInt();

            int result = 100/num;

            // 배열의 인덱스 에러
            System.out.println(arr[result]);

            String ss = null;
            // nullptr 에러
            ss.equals("메롱");

                        /*
             - 다중 catch문은 실제로 에러가 발생하면
              위에서부터 순서대로 catch문을 검색하면서 내려오기 때문에
              부모 타입의 예외를 자식 타입의 예외보다 위에 작성하시면 안됩니다.

             - catch 옆에 괄호에 예외 타입을 여러 개 작성하고 싶은 경우는
              | 기호를 사용하여 타입을 나열해 주시면, 하나의 catch 블록으로
              여러 타입의 예외를 동시에 처리할 수 있습니다.
              (java 7버전부터 가능한 문법)
             */

        } catch (NullPointerException e) {
            System.out.println("주소가 null입니다.");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열 범위를 벗어남.");
        } catch (InputMismatchException e){
            System.out.println("정수를 입력하시오");
        } catch (ArithmeticException e){
            System.out.println("0을 입력하면 안되요");
        } catch (Exception e) {
            System.out.println("이건 무슨 오류일까나");
        } finally {

        }


        sc.close();
    }
}
