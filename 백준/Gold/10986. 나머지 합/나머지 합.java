import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long result = 0;
        long[] D = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            //부분합 + 나머지0
            D[i] = D[i-1] + Integer.parseInt(st.nextToken());
            if(D[i]%M==0) result++;
        }

        long[] R = new long[M];
        for(int i=1;i<N+1;i++){
            long mod = D[i]%M;
            if (mod < 0) mod += M;
            R[(int)mod]++;
        }

        for(int i=0;i<M;i++){
            result+=R[i]*(R[i]-1)/2;
        }
        System.out.println(result);
    }
}

