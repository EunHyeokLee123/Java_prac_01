package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] student = new int[count];
        for (int i = 0; i < count; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        int num = 1; int max = student[0];
        for (int i = 1; i < count; i++) {
            if(student[i] > max){
                max = student[i];
                num++;
            }
        }
        System.out.println(num);


        br.close();
    }
}
