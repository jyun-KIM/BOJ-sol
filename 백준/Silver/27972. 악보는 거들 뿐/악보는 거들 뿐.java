import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int down=0; //연속 감소
        int up=0; //연속 증가
        int ans=0;

        for(int i=0;i<n-1;i++){
            int next = Integer.parseInt(st.nextToken());
            if(prev<next){
                down=0;
                up++;
                ans = Math.max(ans,up);
            }else if(prev>next){
                up=0;
                down++;
                ans = Math.max(ans,down);
            }
            prev=next;
        }
        System.out.println(ans+1);
    }
}