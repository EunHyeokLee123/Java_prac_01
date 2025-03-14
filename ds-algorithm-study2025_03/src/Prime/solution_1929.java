package Prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_1929 {

    static int[] isPrime2(int s, int e){
        int[] arr = new int[e+1];

        for (int i = 2; i <= e ; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= e ; i++) {
            if(arr[i] == 0) continue;

            for (int j = i+i; j <= e ; j+=i) {
                arr[j] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[] prime = isPrime2(start, end);
        for (int i = start; i <= end ; i++) {
            if(prime[i] != 0){
                sb.append(prime[i]+"\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}
