package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {42, 14, 35, 1, 33, 68, 8};
        final int LEN = arr.length;

        for (int i = 0; i < LEN - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < LEN; j++) {
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }


    }
}
