package stack.solution_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cur = 1; // 스택에 넣을 현재 값
        StringBuilder st = new StringBuilder();
        boolean flag = true; // 수열 표현 가능 여부

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i]; // 수열의 값을 순차적으로 가져옴.
            // 주어진 수열 값까지 스택에 값을 push
            while(cur <= num){
                stack.push(cur);
                st.append("+\n");
                cur++;
            }
            if(stack.peek() == num){
                stack.pop();
                st.append("-\n");
            }
            else{
                flag = false; // 수열로 표현할 수 없음.
            }
        }

        if(flag){
            System.out.println(st);
        }
        else
            System.out.println("NO");

        br.close();
    }
}
