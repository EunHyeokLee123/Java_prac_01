package CodeStudy.solution_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < len; i++) {
            int start = 0;
            int end = len - 1;
            while(start < end){
                if(start == i || end == i){
                    if(start == i)
                        start++;
                    else
                        end--;
                }
                else{
                    int now = arr[start] + arr[end];
                    if(arr[i] == now){
                        count++;
                        break;
                    } else if (now < arr[i]) {
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
