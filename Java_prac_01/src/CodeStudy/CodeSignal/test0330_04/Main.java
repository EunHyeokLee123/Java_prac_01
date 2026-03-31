package CodeStudy.CodeSignal.test0330_04;

import java.io.IOException;
import java.util.TreeSet;

public class Main {


    // int[] heigth가 주어지고, viewingGap이 주어짐
    // viewingGap을 넘는 인덱스의 배열값 2개의 차의 절대값이 가장 작은 것을 찾는것.
    // 구현은 했으나, 시간복잡도에서 걸렸음
    public static void main(String[] args) throws IOException {
        int[] height = {1, 5, 7, 10, 45, 99};
        int viewingGap = 3;

        int min = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < height.length - viewingGap; i++){
            if(i - viewingGap >= 0){
                set.add(height[i - viewingGap]);
            }
            if(set.isEmpty()){
                continue;
            }
            int cur = height[i];

            Integer lower = set.floor(cur);
            Integer upper = set.ceiling(cur);

            if(lower != null) {
                min = Math.min(min, Math.abs(cur - lower));
            }
            if(upper != null) {
                min = Math.min(min, Math.abs(cur - upper));
            }
        }

        System.out.println(min);

    }

}
