package recursive;

import java.util.Arrays;

public class Fibonacci {

    static long[] arr;

    public static long fibo(int n){
        // 메모이제이션 : dp 기법 중 하나
        // 이미 배열에 값을 적어놨다면, 계속해서 재귀함수를 호출할 필요가 없음.
        if(arr[n] > 0){
            return arr[n];
        }
        if(n == 1){
            return arr[n] = 1;
        } else if ( n == 2) {
            return arr[n] = 1;
        }else {
            return arr[n] = fibo(n-1) + fibo(n-2);
        }
    }

    static StringBuilder str = new StringBuilder();

    // 10진수 정수를 2진수로 변환하여 출력하는 로직을 작성(재귀)
    public static int conversionToBinary(int n){
        if(n == 1){
            str.insert(0, 1);
            System.out.println(str);
            return 0;
        } else if (n == 0) {
            str.insert(0, 0);
            System.out.println(str);
            return 1;
        }
        else{
            str.insert(0, n % 2);
            return  conversionToBinary(n/2);
        }
    }

    public static void main(String[] args) {

        int n= 100;
        arr = new long[n + 1];
        long re = fibo(n);
        System.out.println(re);
        System.out.println(Arrays.toString(arr));

        conversionToBinary(245);
    }
}
