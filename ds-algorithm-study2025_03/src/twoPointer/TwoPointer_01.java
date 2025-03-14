package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer_01 {

    static StringBuilder solution(int[] arr1, int[] arr2, int size1, int size2){
        StringBuilder sb = new StringBuilder();
        int i1 = 0, i2 = 0;
        while(i1 < size1 && i2 < size2){
            if(arr1[i1] == arr2[i2]){
                sb.append(arr1[i1++]).append(" ");
                sb.append(arr2[i2++]).append(" ");
            } else if (arr1[i1] > arr2[i2]) {
                sb.append(arr2[i2++]).append(" ");
            }
            else {
                sb.append(arr1[i1++]).append(" ");
            }
        }
        while(i1<size1)
            sb.append(arr1[i1++]).append(" ");
        while(i2<size2)
            sb.append(arr2[i2++]).append(" ");

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[size1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int size2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[size2];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(st1.nextToken());
        }

        StringBuilder result = solution(arr1, arr2, size1, size2);
        System.out.print(result);

        br.close();
    }
}
