import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        //l~r까지 하나씩 빼서
        while(l<=r){
            //숫자를 배열로 바꾸고
            char[] arr = Integer.toString(l).toCharArray();
            boolean flag = true;
            //비교
            for(char c:arr){
                if(c !='0' && c != '5') flag=false;
            }
            if(flag){
                int num = Integer.parseInt(new String(arr));
                list.add(num); 
            }
            l++;
        }
        
        int size = list.size();
        // System.out.println(size);
        
        if(size==0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[size];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }
}