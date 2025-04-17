package CodeStudy.solution_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int peopleNum;
    static ArrayList<ArrayList<Integer>> people;
    static boolean[] visited;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static int BFS(int start, int end) {
        int result = 0;
        visited[start] = true;
        queue.offer(start);
        int len = queue.size();
        while(len > 0) {
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                visited[now] = true;
                if(now == end) {
                    return result;
                }
                else{
                    for (int j = 0; j < people.get(now).size(); j++) {
                        if(!visited[people.get(now).get(j)]) {
                            queue.offer(people.get(now).get(j));
                        }
                    }
                }
            }
            result++;
            len = queue.size();
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        peopleNum = Integer.parseInt(br.readLine());
        people = new ArrayList<>();
        for (int i = 0; i <= peopleNum; i++) {
            people.add(new ArrayList<>());
        }
        visited = new boolean[peopleNum + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a1 = Integer.parseInt(st1.nextToken());
            int a2 = Integer.parseInt(st1.nextToken());
            people.get(a1).add(a2);
            people.get(a2).add(a1);
        }

        int result = BFS(start, end);
        System.out.println(result);

        br.close();

    }
}
