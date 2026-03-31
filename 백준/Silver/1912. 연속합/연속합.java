import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n]; //0부터 i까지 누적합
        st = new StringTokenizer(br.readLine());
        dp[0]=Integer.parseInt(st.nextToken());
        int answer=Integer.MIN_VALUE;
        //첫번째 수부터 누적으로 더하면서 최댓값을 dp배열에 저장
        for(int i=1;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+temp, temp);
            answer=Math.max(answer,dp[i]);
        }
        System.out.println(Math.max(answer,dp[0]));
    }
}