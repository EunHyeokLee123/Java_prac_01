package basic.Array;

import java.util.Arrays;

public class ArrayExample_03 {
    public static void main(String[] args) {
        int[] arr = {10,50,90,100,150};
        int newNum = 96;
        int tar = 3;

        int[] tmp = new int[arr.length+1];

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < tmp.length - 1; i++) {
            tmp[i] = arr[i];
        }
        // 뒤에서부터 한칸씩 뒤로 이동
        for(int i = tmp.length-1; i > tar; i--){
            int temp = tmp[i];
            tmp[i] = tmp[i-1];
            tmp[i-1] = temp;
        }
        tmp[tar] = newNum;
        arr = tmp; tmp = null;
        // Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
