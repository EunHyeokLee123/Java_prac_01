package CodeStudy.solution_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    
    // 지도의 크기
    static int len;
    // 입력값 받는 리스트
    static ArrayList<ArrayList<Integer>> arr;
    // 영역 개수
    static int count = 0;
    // 영역별 집의 개수 저장용
    static LinkedList<Integer> resultlist = new LinkedList<>();
    // 영역별 집의 개수를 세는 용도
    static int temp = 0;
    // 상하좌우 탐색을 위한 x, y값 배열 2개
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 집(1인 값)을 찾기 위한 메소드
    public static int[] findPa(){
        // 만약 집이 더이상 없으면 [-1, -1] 리턴
        int[] result = {-1, -1};
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if(arr.get(i).get(j) == 1){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 최대한 긴 길을 찾는 걸로 가자
    public static void DFS(int x, int y){
        // 방문 처리
        arr.get(x).set(y, -1);
        // 집의 개수 갱신
        temp++;
        for (int i = 0; i < dx.length; i++) {
            // 상하좌우 좌표값 계산
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 좌표값의 유효성 확인
            if(nx >=0 && ny >=0 && nx < len && ny < len){
                // 집을 찾으면
                if(arr.get(nx).get(ny) == 1)
                    // 그 집에서 다시 DFS 함수 호출
                    DFS(nx, ny);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if(line[j] == '1')
                    arr.get(i).add(1);
                else
                    arr.get(i).add(0);
            }
        }
        while(true){
            // 먼저 집을 하나 찾음
            int[] tmp = findPa();
            // 집이 더이상 없으면 break
            if(tmp[0] == -1){
                break;
            }
            // 번지의 집의 개수를 초기화 (static으로 계속 쓸거라서)
            temp = 0;
            // DFS 실행
            DFS(tmp[0], tmp[1]);
            // 종료되면 결과리스트에 집의 개수 삽입
            resultlist.add(temp);
            // 단지 개수 갱신
            count++;
        }
        // 오름차순 정렬
        Collections.sort(resultlist);
        System.out.println(count);
        for (Integer i : resultlist) {
            System.out.println(i);
        }

        br.close();
    }
}
