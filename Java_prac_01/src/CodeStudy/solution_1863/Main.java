package CodeStudy.solution_1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int result = 0;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                if(y != 0) {
                    stack.push(y);
                }
            }
            else {
                int count = 0;
                boolean same = false;
                while(!stack.isEmpty()) {
                    if(stack.peek() > y) {
                        stack.pop();
                        count++;
                    }
                    else {
                        if(stack.peek() == y) {
                            same = true;
                        }
                        break;
                    }
                }

                result += count;
                if(!same && y != 0) {
                    stack.push(y);
                }
            }
        }
        br.close();

        result += stack.size();
        System.out.println(result);

    }

}
