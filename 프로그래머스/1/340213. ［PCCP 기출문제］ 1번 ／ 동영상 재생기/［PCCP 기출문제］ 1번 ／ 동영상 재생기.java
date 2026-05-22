import java.util.*;


class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = toSec(video_len);
        int posSec = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        
        for(String c:commands){
            if(opStartSec<=posSec && posSec<=opEndSec) posSec=opEndSec;
            if(c.equals("next")) {
                posSec+=10;
                if(posSec>videoLenSec) posSec=videoLenSec;
            }
            else{ 
                posSec-=10;
                if(posSec<0) posSec=0;
            }
        }
        if(opStartSec<=posSec && posSec<=opEndSec) posSec=opEndSec;
        
        int mm=posSec/60;
        int ss=posSec%60;
        
        return String.format("%02d:%02d", mm,ss);
    }
    
    public int toSec(String time){
        String[] t=time.split(":");
        int min = Integer.parseInt(t[0]);
        int sec = Integer.parseInt(t[1]);
        
        return 60*min+sec;
    }
}