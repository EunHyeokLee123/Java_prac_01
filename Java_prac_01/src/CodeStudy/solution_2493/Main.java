package CodeStudy.solution_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length; i++) {
            while(!stack.isEmpty()) {
                if(arr[stack.peek()] >= arr[i]) {
                    sb.append(stack.peek() + 1).append(" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            }

            stack.push(i);
        }

        System.out.println(sb);

        br.close();
    }

}
