import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
          arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int answer=arr[0];
        //dp[i]는 i를 포함하는 부분수열 합 최댓값 
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                    // System.out.printf("dp[i]: %d. arr[j]: %d\n", dp[i],arr[j]);
                }
            }
            answer=Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}