package basic.Two_DimArray;

public class Two_ArrayExample_01 {
    public static void main(String[] args) {

        String[] stuName = {"A학생", "B학생", "C학생", "D학생"};
        String[] subName = {"국어", "영어", "수학"};

        /*
         1. 각 학생의 평균을 소수점 첫째 자리까지 출력해 보세요.
         2. 각 과목의 평균을 출력해 보세요.
         3. 반 평균을 출력해 보세요. (모든 학생들의 평균을 더해서 학생수로 나누기)
         */

        int[][] score = { // 과목 3개  학생 4명
                {60,80,55},  // A
                {40,80,100},   // B
                {80,95,88},    // C
                {100,100,100},   // D
        };
        int i = 0;
        // 학생의 평균
        for (int[] tmp : score) {
            int result = 0;
            for (int idx : tmp){
                result += idx;
            }
            double avg = (double) result/(tmp.length);
            System.out.printf(stuName[i]+"의 평균은 %.1f \n"
                    , avg);
            i++;
        }
        System.out.println("=========================");
        // 과목 평균

        for (int j = 0; j < subName.length; j++) {
            int  re1 = 0;
            for (int k = 0; k < stuName.length; k++) {
                re1 += score[k][j];
            }
            double tmp = (double) re1/ score.length;
            System.out.printf(subName[j]+"과목의 평균점수는 %.1f \n", tmp);
        }
        System.out.println("========================");
        // 반 평균
        double re = 0.0;
        for (int j = 0; j < score.length; j++) {
            double tmp = 0.0;
            for (int k = 0; k < score[j].length; k++) {
                tmp += score[j][k];
            }
            tmp = tmp/ subName.length;
            re += tmp;
        }
        re = re/ stuName.length;
        System.out.printf("반평균은 %.1f점입니다. \n", re);
    }
}
