import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        int[] addSchedules = new int[n];
        //schedules + 10 각각
        for(int i=0;i<n;i++){
            addSchedules[i] = schedules[i]+10;
            if(addSchedules[i]%100 >= 60){
                addSchedules[i] = (addSchedules[i]/100 + 1)*100 + (addSchedules[i]%100-60);
            }
        }
        // System.out.println(Arrays.toString(addSchedules));
        int i=0;
        boolean flag = true;
        //timelogs를 돌면서 
        for(int[] logs:timelogs){
            int day=startday;
            for(int l:logs){
                //startday==6,7이면 continue
                if(day==6 || day==7) {
                    day+=1;
                    if(day>7){
                        day%=7;
                    }
                    continue;
                }
                //schedules<timelogs 면 break
                if(addSchedules[i]<l){
                    flag=false;
                    break;
                }
                day+=1;
                if(day>7){
                    day%=7;
                }
            }
            //끝까지 왔으면 answer+=1
            if(flag) answer+=1;
            i+=1;
            flag=true;
        }

        return answer;
    }
}