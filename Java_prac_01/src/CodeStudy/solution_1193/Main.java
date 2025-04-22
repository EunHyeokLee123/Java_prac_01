package CodeStudy.solution_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tar = Integer.parseInt(br.readLine());

        int layer = 0;
        int res = 0; int start = 1;
        while(true){
            int temp = start*(start+1)/2;
            if(temp >= tar){
                layer = start + 1;
                res = tar - (start-1)*start/2;
                break;
            }
            start++;
        }

        if(layer % 2 == 0){
            System.out.printf("%d/%d", layer - res, res);
        }
        else{
            System.out.printf("%d/%d", res, layer- res);
        }



        br.close();
    }
}
