package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            StringBuilder tmp = new StringBuilder(st.nextToken());
            String temp = new String(tmp.reverse());
            int i1 = Integer.parseInt(temp.replace("0",""));
            boolean mid = true;
            if(i1 == 1 || (i1 != 2 && i1 % 2 == 0))
                mid = false;
            else if (i1 == 2) {
            }
            else{
                // 굳이 j를 i1 -1까지 탐색할 필요 X
                // sqrt(i1) 까지의 숫자까지만 탐색하면 됨.
                for (int j = 2; j * j <= i1; j++) {
                    if(i1 % j == 0) {
                        mid = false;
                    }
                }
            }
            if(mid)
                System.out.printf("%d ", i1);
        }


        br.close();
    }
}
