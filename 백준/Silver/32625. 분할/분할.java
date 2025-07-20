import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int flag=1;
        int sum=0;
        
        for(int section=1;section<n;section++){
            if(n%section != 0) continue;
            for(int start=0;start<n;start+=section){
                int min=A[start];
                int max=A[start];
                for(int j=start;j<start+section;j++){
                    min=Math.min(min,A[j]);
                    max=Math.max(max,A[j]);
                }
                
                if(start==0){
                    sum=min+max;
                }else{
                    if(sum!=min+max) {
                        
                        flag=0;
                        break;
                    }else flag=1;
                }
            }
            
        }
        System.out.println(flag);
    }

    
}