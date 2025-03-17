package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class solution_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch1 = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();

        HashMap<Character, Integer> tar1 = new HashMap<>();
        HashMap<Character, Integer> tar2 = new HashMap<>();


        for (int i = 0; i < ch1.length; i++) {
            tar1.put(ch1[i], tar1.getOrDefault(ch1[i], 0)+1);
            tar2.put(ch2[i], tar2.getOrDefault(ch2[i], 0)+1);
        }
        boolean result = true;
        for (Character c : tar1.keySet()) {
            if(tar1.get(c) != tar2.get(c))
                result = false;
        }
        for (Character c : tar2.keySet()) {
            if(tar1.get(c) != tar2.get(c))
                result = false;
        }
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
