package CodeStudy.solution_3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Team {
        int num;
        int[] score;
        int tries;
        int last;
        int total;
        Team(int num, int[] score, int tries, int last, int total) {
            this.num = num;
            this.score = score;
            this.tries = tries;
            this.last = last;
            this.total = total;
        }
    }

    static Team[] teams;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder("");
        StringTokenizer st;
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            teams = new Team[Integer.parseInt(st.nextToken())];
            int problem = Integer.parseInt(st.nextToken());
            int tar = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            for(int j = 0; j < teams.length; j++) {
                teams[j] = new Team(j + 1, new int[problem + 1], 0, 0, 0);
            }
            for(int j = 1; j <= length; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int team = Integer.parseInt(st.nextToken()) - 1;
                int pro = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());
                if(teams[team].score[pro] < sc) {
                    teams[team].total -= teams[team].score[pro];
                    teams[team].score[pro] = sc;
                    teams[team].total += sc;
                }
                teams[team].tries++;
                teams[team].last = j;
            }

            Arrays.sort(teams, (a, b) -> {
                if(a.total == b.total) {
                    if(a.tries == b.tries) {
                        return a.last - b.last;
                    }
                    else {
                        return a.tries - b.tries;
                    }
                }
                else {
                    return b.total - a.total;
                }
            });

            for(int j = 0; j < teams.length; j++) {
                if(teams[j].num == tar) {
                    result.append(j + 1).append("\n");
                    break;
                }
            }

        }


        System.out.println(result);





        br.close();
    }

}
