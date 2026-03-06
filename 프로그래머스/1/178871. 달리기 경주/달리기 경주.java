import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        for (String call: callings){
            int rank=map.get(call);
            String temp=players[rank-1]; //추월 당한
            players[rank-1]=call;
            players[rank]=temp;
            map.put(call, rank-1);
            map.put(temp, rank);
        }
        return players;
    }
}