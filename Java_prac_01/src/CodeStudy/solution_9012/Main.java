package CodeStudy.solution_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder st = new StringBuilder();
        for (int j = 0; j < len; j++) {
            char[] ccc = br.readLine().toCharArray();
            Stack<Character> ch = new Stack<>();
            boolean tmp = true;
            for (int i = 0; i < ccc.length; i++) {
                if(ccc[i] == '(')
                    ch.push('(');
                else if (ccc[i] == ')') {
                    if (!ch.isEmpty()) {
                        ch.pop();
                    }
                    else{
                        tmp = false;
                    }
                }
            }
            if(ch.isEmpty() && tmp){
                st.append("YES\n");
            }
            else{
                st.append("NO\n");
            }
        }
        System.out.println(st);

    }
}
