package CodeStudy.solution_20006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int len;
    static int range;
    static List<Room> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static class Player {
        int level;
        String name;
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        boolean start;
        List<Player> players = new ArrayList<>();
        // 방장의 레벨
        int stand;
        // 방 생성
        public Room(Player a1) {
            this.start = false;
            stand = a1.level;
            players.add(a1);
            if(players.size() == range) {
                start = true;
            }
        }
        // 플레이어 참가
        public void addPlayer(Player p) {
            players.add(p);
            if(players.size() == range) {
                start = true;
            }
        }
    }

    // 현재 플레이어가 들어갈 수 있는 방의 idx를 리턴
    static int findRoom(int now) {
        for(int i = 0; i < list.size(); i++) {
            // 아직 시작하지 않은 방 중에서
            if(!list.get(i).start) {
                int stand = list.get(i).stand;
                if(Math.abs(now - stand) <= 10) {
                    return i;
                }
            }
        }
        // 가능한 방이 없으면 -1을 리턴
        return -1;
    }

    static void startGame(Room tar) {
        if(tar.start) {
            sb.append("Started!").append("\n");
        }
        else {
            sb.append("Waiting!").append("\n");
        }

        tar.players.sort((a, b) -> {
            return a.name.compareTo(b.name);
        });

        for(int i = 0; i < tar.players.size(); i++) {
            sb.append(tar.players.get(i).level).append(" ").append(tar.players.get(i).name).append("\n");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());

        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Player tp = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            int idx = findRoom(tp.level);
            if(idx == -1) {
                Room r = new Room(tp);
                list.add(r);
            }
            else {
                list.get(idx).addPlayer(tp);
            }
        }

        for(int i = 0; i < list.size(); i++) {
            startGame(list.get(i));
        }

        sb.delete(sb.length() - 1, sb.length());

        System.out.println(sb);

        br.close();
    }

}
