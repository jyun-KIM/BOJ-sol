import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1]; //dp[i] = i원이 될 때까지의 최소 동전 개수
        int[] coin = new int[n];
    
        for(int i=0;i<=k;i++){
            dp[i]=100001;
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            if(c<=k){
                coin[i]=c;
                dp[coin[i]]=1;
            }
            
            // System.out.println(coin[i]);
        }
        for(int i=0;i<=k;i++){
            for(int j=0;j<n;j++){
                if(i-coin[j]>0){
                    dp[i] = Math.min(dp[i],dp[i-coin[j]]+1);
                }
            }
        }
        
        if(dp[k]!=100001){
            System.out.println(dp[k]);
        }else{
            System.out.println(-1);
        }
    }

}