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
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int k=0;
        int cnt=0;

        while(k!=n){
            long find = A[k];
            int i=0;
            int j=n-1;
            while(i<j){
                if((A[i]+A[j]) == find){
                    if(i!=k && j!=k){
                    cnt++;
                    break;
                    }else if(i==k){
                        i++;
                    }else{
                        j--;
                    }
                }else if((A[i]+A[j])<find){
                    i++;
                }else{
                    j--;
                }
            }
            k++;
        }
        System.out.println(cnt);
        bf.close();
    }
}