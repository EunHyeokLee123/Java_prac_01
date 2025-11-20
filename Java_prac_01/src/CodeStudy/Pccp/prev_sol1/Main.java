package CodeStudy.Pccp.prev_sol1;



// Pccp 대비 기출문제 1번을 풀어보자. lv1
public class Main {

    static class Solution {

        public int[] extractTime(String input) {
            int[] answer = new int[2];

            String[] parts = input.split(":");

            for (int i = 0; i < 2; i++) {
                if(parts[i].charAt(0) == '0') {
                    answer[i] = Integer.parseInt(parts[i].substring(1, 2));
                }
                else {
                    answer[i] = Integer.parseInt(parts[i]);
                }
            }

            return answer;
        }

        public String formatTime(int[] answer) {

            String[] ans = new String[2];
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] < 10) {
                    ans[i] = "0" + answer[i];
                }
                else {
                    ans[i] = "" + answer[i];
                }
            }

            return ans[0] + ":" + ans[1];
        }

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            // idx 기준 0은 분, 1은 초
            int[] length = extractTime(video_len);
            int end = length[0] * 60 + length[1];
            int[] now = extractTime(pos);
            int[] op_starts = extractTime(op_start);
            int ops = op_starts[0] * 60 + op_starts[1];
            int[] op_ends = extractTime(op_end);
            int opes = op_ends[0] * 60 + op_ends[1];

            int temp = now[0] * 60 + now[1];
            for (int i = 0; i < commands.length; i++) {

                // 명령어 수행 전 오프닝 스킵 처리 여부 검증
                if(temp >= ops && temp <= opes) {
                    temp = opes;
                }

                if (commands[i].equals("prev")) {
                    temp -= 10;
                    if(temp <= 0) {
                        temp = 0;
                    }
                }
                else if (commands[i].equals("next")) {
                    temp += 10;
                    if(temp >= end) {
                        temp = end;
                    }
                }
                // 명령어 수행 후 오프닝 스킵 처리 여부 확인
                if(temp >= ops && temp <= opes) {
                    temp = opes;
                }
            }

            now[0] = temp / 60;
            now[1] = temp % 60;

            return formatTime(now);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.solution("34:33", "13:00", "00:55",
                "02:55", new String[]{"next", "prev"});

        System.out.println(result);
    }

}
