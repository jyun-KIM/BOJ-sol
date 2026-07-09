import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //hasmap 선언
        HashMap<String, Integer> map = new HashMap<>();
        //participant의 이름과 명수를 key-val로 저장
        for(String p:participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        
        //completion에 있는 이름을
        for(String c:completion){
            map.put(c,map.get(c)-1);
        }
            //participant val-1
        //answer=getval(1)
        for(String key:map.keySet()){
            if(map.get(key)==1) return key;
        }
        return answer;
    }
}