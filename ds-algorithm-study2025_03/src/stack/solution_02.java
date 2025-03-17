package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class solution_02 {

    static int calc(char op, int n1, int n2){
        return switch (op) {
            case '+' -> n1 + n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            case '-' -> n1 - n2;
            default -> 0;
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> num = new Stack<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(Character.isDigit(arr[i]))
                num.push(Integer.parseInt(String.valueOf(arr[i])));
            else{
                int n1 = num.pop(); int n2 = num.pop();
                result = calc(arr[i],n2, n1);
                num.push(result);
            }
        }

        System.out.println(num.pop());
        br.close();
    }
}
