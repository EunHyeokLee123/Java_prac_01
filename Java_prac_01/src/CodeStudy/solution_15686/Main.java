package CodeStudy.solution_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int calDistance(Point p1, Point p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);

        return dx + dy;
    }

    public static List<List<Integer>> makeCombination(int n, int m) {
        List<List<Integer>> res = new ArrayList<>();
        combiBackTrack(0, n, m, new ArrayList<>(), res);
        return res;
    }

    public static void combiBackTrack(int start, int n, int m, List<Integer> current, List<List<Integer>> result){
        if(current.size() == m){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i < n; i++){
            current.add(i);
            combiBackTrack(i + 1, n, m, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st1.nextToken());
        int restCount = Integer.parseInt(st1.nextToken());

        List<Point> chick = new ArrayList<>();
        List<Point> house = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < len; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    house.add(new Point(j, i));
                }
                else if(temp == 2){
                    chick.add(new Point(j, i));
                }
            }
        }

        // 치킨집의 조합의 경우의 수를 저장할 리스트, index를 기준으로 저장하겠다.
        List<List<Integer>> combi = makeCombination(chick.size(), restCount);

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < combi.size(); i++) {
            List<Integer> temp = combi.get(i);
            List<Point> nowChick = new ArrayList<>();
            // 현재 조합의 경우의 수에서의 치킨집의 좌표들
            for (int j = 0; j < temp.size(); j++) {
                nowChick.add(chick.get(temp.get(j)));
            }
            int midResult = 0;
            for (int k = 0; k < house.size(); k++) {
                Point nowHouse = house.get(k);
                int midSum = Integer.MAX_VALUE;
                for (int j = 0; j < nowChick.size(); j++) {
                    int dis = calDistance(nowHouse, nowChick.get(j));
                    if(dis < midSum){
                        midSum = dis;
                    }
                }
                midResult += midSum;
            }

            if(midResult < minResult){
                minResult = midResult;
            }

        }

        System.out.println(minResult);


        br.close();
    }

}
