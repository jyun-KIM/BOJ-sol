import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] S = new long[n+1];
        S[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(S[b]-S[a-1]);
        }
    }
}
