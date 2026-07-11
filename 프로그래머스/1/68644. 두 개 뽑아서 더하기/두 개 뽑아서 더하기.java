import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        //hashset 선언
        HashSet<Integer> set = new HashSet<>();
        //for(i=0)
        for(int i=0;i<numbers.length;i++){
            //for(j=1)
            for(int j=i+1;j<numbers.length;j++){
                //set.add(numbers[i]+numbers[j])
                set.add(numbers[i]+numbers[j]);
                // System.out.println(set);
            }
        }
        
        answer = set.stream()
               .mapToInt(Integer::intValue)
               .toArray();
        Arrays.sort(answer);
        return answer;
    }
}