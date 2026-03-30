import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; //i를 포함했을 때 i부터 시작하는 가장 긴 길이 
        int answer=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);

                }
            }
            answer=Math.max(answer,dp[i]);
        }

        System.out.println(answer);
        
    }
}