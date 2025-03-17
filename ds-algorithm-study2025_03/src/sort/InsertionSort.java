package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {42, 14, 35, 1, 33, 68, 8};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            // j가 -1이 되거나 기준으로 삼은 값이 앞의 값보다 크면 반복문 종료
            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }
}
