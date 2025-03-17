package sort;

import java.util.Arrays;

public class QuickSort {



    public static void main(String[] args) {
        int [] arr = {42, 14, 35, 1, 33, 68, 8};
        quicksort(arr, 0, arr.length -1);

    }

    private static void quicksort(int[] arr, int low, int high) {
        if(low < high){
            int pivotIndex = partition(arr, low, high);

            // pivot 인덱스보다 작은 영역의 정렬을 계속 반복
            quicksort(arr, low, pivotIndex - 1);
            // pivot 인덱스보다 큰 영역의 정렬을 계속 반복
            quicksort(arr, pivotIndex + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // pivot을 올바른 위치에 적용시키기
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;
        System.out.println("분할 후의 상태 : " + Arrays.toString(arr));
        System.out.println("피봇 위치 : " + i + "피봇 값 : " + arr[i]);
        return i;
    }
}
