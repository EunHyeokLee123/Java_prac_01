package etc.api.lang.system;

import java.util.Scanner;

public class SystemTime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        long re = 0;
        System.out.println("정수를 입력하시오.");
        int str = sc.nextInt();
        for (int i = 0; i < str; i++) {
            re+=i;
        }
        System.out.println("re = " + re);
        long end = System.currentTimeMillis();
        long term = end-start;
        System.out.println("term = " + term + "ms");
        System.out.println(System.getProperties());
        sc.close();

    }
}
