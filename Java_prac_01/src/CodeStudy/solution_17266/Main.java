package CodeStudy.solution_17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int length;
    static int count;
    static int[] idx;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());
        idx = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < count; i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }

        int height = 0;
        if(count == 1) {
            height = Math.max(idx[0], length - idx[0]);
        }
        else {
            for(int i = 0; i < count; i++) {
                if(i == 0) {
                    height = Math.max(idx[i], (int) Math.ceil((idx[i + 1] - idx[i]) / 2.0));
                }
                else if(i == count - 1) {
                    height = Math.max(height, length - idx[i]);
                }
                else {
                    height = Math.max(height, (int) Math.ceil((idx[i + 1] - idx[i]) / 2.0));
                }
            }
        }


        System.out.println(height);





        br.close();
    }

}
