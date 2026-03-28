import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+2]; //i부터 퇴사일까지 벌 수 있는 최대 금액 
        //거꾸로 돌면서 확인
        for(int i=n;i>0;i--){
            if(T[i]+i>n+1) {
                dp[i]=dp[i+1];
            }
            else{
                int x = dp[i+T[i]] + P[i]; //오늘 일을 했을 때
                dp[i] = Math.max(dp[i+1], x);
            }
        }
        //현재 날짜+T[i]가 n보다 크다면 패스
        //answer=max(오늘 일을 할 때, 안 할때)
        //오늘 일을 하면 그만큼 
        System.out.println(dp[1]);
    }
}