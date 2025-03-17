package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class solution_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ')'){
                while(stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            }
            else{
                stack.push(arr[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        System.out.println(result.reverse());


        br.close();
    }
}
