package CodeStudy.solution_26517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(br.readLine());
        long[] arr = new long[4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // tmp가 클 수 있어서 long으로 받아야 함.
        long tmp = arr[0]*x + arr[1];
        if(tmp == arr[2]*x + arr[3]){
            System.out.println("Yes " + tmp);
        }
        else{
            System.out.println("No");
        }


        br.close();
    }
}
