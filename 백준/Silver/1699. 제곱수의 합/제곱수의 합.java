import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = 100000;
        }
        dp[1]=1;
        int tmp=2; //제곱수 판별 
        //1부터 n까지 돌면서 dp테이블 채우기
        for(int i=2;i<n+1;i++){
            //제곱수이면 1
            if(i==tmp*tmp){
                dp[i]=1;
                tmp++;
            }
            else{
                //아니면 1~i-1까지 돌면서 더해서 i인 값 중 최솟값으로 배열 채우기 
                for(int j=1;j<=i/2;j++){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);

                }
            }
        }
        System.out.println(dp[n]);

    }
}