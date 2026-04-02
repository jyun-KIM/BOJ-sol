import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long[][][] dp;
    static long w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        if(a>20 || b>20 || c>20) return w(20,20,20);
        if(dp[a][b][c]!=0) return dp[a][b][c];
        
        if(a<b && b<c){
            dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
            // dp[a][b][c]=dp[a-1][b][c]+dp[a-1][b-1][c]+dp[a-1][b][c-1]-dp[a-1][b-1][c-1];
        }else{
            dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }
        return dp[a][b][c];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = 
        dp = new long[21][21][21];
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) return;
            // System.out.println(w(a,b,c));
            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
        }
    }
}