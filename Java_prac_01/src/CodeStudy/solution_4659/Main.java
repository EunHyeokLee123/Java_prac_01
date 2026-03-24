package CodeStudy.solution_4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    static boolean isAcceptable(String input) {
        boolean hasVowel = false;
        boolean frontVowel = false;
        int contiVowel = 0;
        int contiNo = 0;

        for(int i = 0; i < input.length(); i++) {
            // 모음 여부 확인
            if(vowels.contains(input.charAt(i))) {
                hasVowel = true;
                // 앞에도 모음이였던 경우
                if(frontVowel) {
                    // 모음 연속 3개는 불가능
                    if(contiVowel == 2) {
                        return false; 
                    }
                    // 같은 글자가 연속으로 온 경우
                    if(i > 0 && input.charAt(i - 1) == input.charAt(i)) {
                        if(input.charAt(i) != 'e' && input.charAt(i) != 'o') {
                            return false;
                        }
                    }
                }
                contiNo = 0;
                contiVowel++;
                frontVowel = true;
            }
            // 자음인 경우
            else {
                // 앞에도 자음인 경우
                if(!frontVowel) {
                    // 자음 연속 3개는 불가능
                    if(contiNo == 2) {
                        return false;
                    }
                    // 같은 자음이 연속 2개는 불가능
                    if(i > 0 && input.charAt(i - 1) == input.charAt(i)) {
                        return false;
                    }
                }
                contiNo++;
                contiVowel = 0;
                frontVowel = false;
            }
        }
        if(!hasVowel) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals("end")) break;

            String tp = "<" + line + ">";
            if(isAcceptable(line)) {
                tp += " is acceptable.";
            }
            else{
               tp += " is not acceptable.";
            }

            result.append(tp).append("\n");
        }


        System.out.println(result);





        br.close();
    }

}
