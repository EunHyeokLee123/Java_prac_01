package CodeStudy.solution_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
                st.append(input.charAt(i));
            }
            else{
                operations.add(input.charAt(i));
                int temp = Integer.parseInt(st.toString());
                numbers.add(temp);
                st.delete(0, st.length());
            }
        }
        numbers.add(Integer.parseInt(st.toString()));

        int result = numbers.get(0);
        boolean minus = false;

        for (int i = 0; i < operations.size(); i++) {
            if(operations.get(i) == '-'){
                minus = true;
            }

            if(minus){
                result -= numbers.get(i + 1);
            }
            else{
                result += numbers.get(i + 1);
            }
        }

        System.out.println(result);
        br.close();
    }

}
