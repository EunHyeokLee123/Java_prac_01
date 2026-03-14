package CodeStudy.solution_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Student {
        boolean man;
        int idx;
        Student(boolean man, int idx) {
            this.man = man;
            this.idx = idx;
        }
    }

    static int[] arr;
    static Student[] stu;

    static void man(int idx) {
        int i = 1;
        while(i * idx < arr.length) {
            if(arr[i * idx] == 1) {
                arr[i * idx] = 0;
            }
            else {
                arr[i * idx] = 1;
            }
            i++;
        }
    }

    static void woman(int idx) {
        int left = idx - 1;
        int right = idx + 1;
        while(left > 0 && right < arr.length) {
            if(arr[left] == arr[right]) {
                left--;
                right++;
            }
            else {
                break;
            }
        }
        for(int i = left + 1; i < right; i++) {
            if(arr[i] == 1) {
                arr[i] = 0;
            }
            else {
                arr[i] = 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = Integer.parseInt(br.readLine());
        stu = new Student[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String sx = st.nextToken();
            int idx = Integer.parseInt(st.nextToken());
            if(sx.equals("1")) {
                stu[i] = new Student(true, idx);
            }
            else {
                stu[i] = new Student(false, idx);
            }
        }

        for(int i = 0; i < stu.length; i++) {
            if(stu[i].man) {
                man(stu[i].idx);
            }
            else {
                woman(stu[i].idx);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 1; i < arr.length; i++) {
            ans.append(arr[i]).append(" ");
            if(i % 20 == 0) {
                ans.append("\n");
            }
        }

        System.out.println(ans);

        br.close();
    }

}
