import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        for (int i=1;i<=n;i++){
            A[i]=i;
        }
        int sum=1;
        int end_idx=1;
        int start_idx=1;
        int cnt=1;

        while(end_idx!=n){
            if (sum<n){
                end_idx++;
                sum+=end_idx;
            }else if(sum>n){
                sum-=start_idx;
                start_idx++;
            }else{
                cnt++;
                end_idx++;
                sum+=end_idx;
            }
        }
        System.out.println(cnt);
    }
}

