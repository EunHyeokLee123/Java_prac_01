package CodeStudy.solution_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    static List<Integer> input = new ArrayList<>();
    static List<Integer> output = new ArrayList<>();
    static List<Integer> primes = new ArrayList<>();
    static HashSet<Integer> primesSet = new HashSet<>();

    static boolean[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            }
            int now = Integer.parseInt(s);
            input.add(now);
            if(now > max){max = now;}
        }

        temp = new boolean[max + 1];
        temp[0] = temp[1] = true;
        for (int i = 2; i * i < max; i++) {
            if(!temp[i]){
                for (int j = i*i; j <= max; j+=i) {
                    temp[j] = true;
                }
            }
        }

        for (int i = 1; i <= max; i++) {
            if(!temp[i]){
                primes.add(i);
                primesSet.add(i);
            }
        }

        for (int i = 0; i < input.size(); i++) {
            int tar = input.get(i);
            boolean found = false;
            for (int j = 0; j < primes.size(); j++) {
                int left = primes.get(j);
                if(primesSet.contains(tar - left)){
                    output.add(left);
                    found = true;
                    break;
                }
            }
            if(!found){
                output.add(-1);
            }
        }


        for (int i = 0; i < input.size(); i++) {
            int n = input.get(i);
            int left = output.get(i);
            if (left == -1) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.printf("%d = %d + %d\n", n, left, n - left);
            }
        }

        br.close();

    }

}
