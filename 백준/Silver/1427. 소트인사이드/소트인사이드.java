import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(bf.readLine());
        int[] A = new int[sb.length()];
        for(int i=0;i<sb.length();i++){
            A[i] = sb.charAt(i)-'0';
        }
        
        for(int i=0;i<A.length-1;i++){
            int maxIdx = i;
            for(int j=i+1;j<A.length;j++){
                if(A[j]>A[maxIdx]) maxIdx = j;
            }
            if(maxIdx != i){
                int temp = A[i];
                A[i] = A[maxIdx];
                A[maxIdx] = temp;
            }
        }
        for(int n:A){
            System.out.print(n);
        }
    }
    
}