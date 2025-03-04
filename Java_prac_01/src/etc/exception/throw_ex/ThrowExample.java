package etc.exception.throw_ex;

import etc.exception.custom.InvalidArgumentException;

import java.util.InputMismatchException;

public class ThrowExample {

    static int calcTotal(int end) throws InvalidArgumentException {

        if(end <=0){
            // System.out.println("잘못된 매개값!");
            throw new InvalidArgumentException("매개값이 이상합니다.");
        }
        int result = 0;
        for (int i = 1; i <= end ; i++) {
            result +=i;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            int tmp = calcTotal(100);
            System.out.println(tmp);

            int tmp2 = calcTotal(-120);
            System.out.println(tmp2);
        } catch (InvalidArgumentException e) {
            System.out.println("매개값이 이상해!");
            e.printStackTrace();
        }

    }
}
