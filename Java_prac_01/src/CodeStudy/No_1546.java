package CodeStudy;

import java.util.Scanner;

public class No_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        double[] arr = new double[len];
        int max = 0; double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            if(num > max)
                max = num;
            sum += num;
        }
        sum = (sum/max*100)/len;
        System.out.println(sum);

        sc.close();
    }
}
