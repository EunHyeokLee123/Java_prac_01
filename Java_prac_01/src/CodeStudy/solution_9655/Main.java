package CodeStudy.solution_9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tar = Integer.parseInt(br.readLine());

        if(tar % 2 == 0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }

        br.close();
    }

}
