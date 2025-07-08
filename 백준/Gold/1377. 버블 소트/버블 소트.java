import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        mData[] A = new mData[n];

        for(int i=0;i<n;i++){
            A[i] = new mData(i,Integer.parseInt(bf.readLine()));
        }
        Arrays.sort(A);
        int max=0;
        for(int i=0;i<n;i++){
            if(max < A[i].idx - i) max=A[i].idx-i;
        }
        System.out.println(max+1);
    }
    
    static class mData implements Comparable<mData>{
        int idx;
        int val;

        public mData(int idx, int val){
            super();
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(mData o){
            return this.val - o.val;
        }
        
    }
    
}