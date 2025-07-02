import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int m=Integer.parseInt(bf.readLine());
        int[] A=new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int cnt=0;
        int idx1=1;
        int idx2=n;
        
        while(idx1<idx2){
            if(A[idx1]+A[idx2] > m) {idx2--;}
            else if(A[idx1]+A[idx2] < m) {idx1++;}
            else{
                cnt++;
                idx1++;
                idx2--;
            }
        }
        System.out.println(cnt);
    }
}