package CodeStudy.solution_12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (start == target) {
            System.out.println(0);
            System.out.println(1);
        }
        else if (start > target) {
            System.out.println(start - target);
            System.out.println(1);
        }
        else {
            int[] times = new int[MAX + 1];
            int[] count = new int[MAX + 1];
            Arrays.fill(times, MAX + 1);
            times[start] = 0;
            count[start] = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int now = queue.poll();
                    // target을 찾은 경우
                    if(now - 1 == target || now + 1 == target || now * 2 == target) {
                        if (now + 1 == target) {
                            if (times[now + 1] >= times[now] + 1) {
                                times[now + 1] = times[now] + 1;
                                count[now + 1]++;
                            }
                        }
                        if (now - 1 == target) {
                            if (times[now - 1] >= times[now] + 1) {
                                times[now - 1] = times[now] + 1;
                                count[now - 1]++;
                            }
                        }
                        if (now * 2 == target) {
                            if (times[now * 2] >= times[now] + 1) {
                                times[now * 2] = times[now] + 1;
                                count[now * 2]++;
                            }
                        }
                    }
                    // target이 아닌 경우
                    else {
                        if(now - 1 >= 0 && times[now - 1] >= times[now] + 1) {
                            queue.offer(now - 1);
                            times[now - 1] = times[now] + 1;
                        }
                        if(now + 1 < target && times[now + 1] >= times[now] + 1) {
                            queue.offer(now + 1);
                            times[now + 1] = times[now] + 1;
                        }
                        if(now * 2 <= MAX && times[now * 2] >= times[now] + 1) {
                            queue.offer(now * 2);
                            times[now * 2] = times[now] + 1;
                        }
                    }
                }
            }
            System.out.println(times[target]);
            System.out.println(count[target]);
        }
        br.close();
    }

}
