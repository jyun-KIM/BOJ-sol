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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int A[][] = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long B[][] = new long[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                B[i][j] = B[i-1][j]+B[i][j-1]-B[i-1][j-1]+A[i][j];
            }
        }
        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
        
            System.out.println(B[x2][y2]-B[x2][y1-1]-B[x1-1][y2]+B[x1-1][y1-1]);
        }
            
    }
}

