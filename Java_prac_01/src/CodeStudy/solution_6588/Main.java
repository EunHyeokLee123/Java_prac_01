package CodeStudy.solution_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> input = new ArrayList<>();
    static List<Integer> output = new ArrayList<>();

    static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            }
            input.add(Integer.parseInt(s));
        }

        for (int i = 0; i < input.size(); i++) {
            int now = input.get(i);
            int tar = input.get(i) / 2;
            for (int j = 3; j <= tar; j+=2) {
                int res = now - j;
                if(isPrime(j)) {
                    if (isPrime(res)) {
                        output.add(j);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < input.size(); i++) {
            System.out.printf("%d = %d + %d\n", input.get(i),output.get(i), input.get(i) - output.get(i));
        }
        br.close();
    }

}
