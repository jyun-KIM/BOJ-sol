import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        // System.out.println(map);
        int i=0;
        for(String[] p:photo){
            int a=0;
            for(String n:p){
                int score = map.getOrDefault(n, 0);
                a+=score;
                // System.out.println(n+a);
            }
            answer[i]=a;
            // System.out.println("answer: "+answer[i]);
            i++;
            // System.out.println(Arrays.toString(answer));
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}