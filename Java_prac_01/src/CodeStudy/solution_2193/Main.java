package CodeStudy.solution_2193;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        if(length == 1) {
            System.out.println(1);
        }
        else if(length == 2) {
            System.out.println(1);
        }
        // 1, 0 까지는 고정임
        else {
            long[] one = new long[length + 1];
            long[] zero = new long[length + 1];
            one[3] = 1; zero[3] = 1;
            for (int i = 4; i <= length; i++) {
                one[i] = zero[i - 1];
                zero[i] = one[i - 1] + zero[i - 1];
            }
            System.out.println(one[length] + zero[length]);
        }

    }

}
