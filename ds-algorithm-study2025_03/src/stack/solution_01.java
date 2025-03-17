package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class solution_01 {
    public static void main(String[] args) throws IOException {
        Stack<Character> ch = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ccc = br.readLine().toCharArray();
        for (int i = 0; i < ccc.length; i++) {
            if(ccc[i] == '(')
                ch.push('(');
            else if (ccc[i] == ')') {
                ch.pop();
            }
        }
        if(ch.empty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
