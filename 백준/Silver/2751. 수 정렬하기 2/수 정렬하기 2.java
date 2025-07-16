import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] A, tmp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        A = new int[n+1];
        tmp = new int[n+1];
        for(int i=1;i<=n;i++){
            A[i] = Integer.parseInt(bf.readLine());
        }

        merge_sort(1,n);
        for(int i=1;i<=n;i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    private static void merge_sort(int s, int e){
        if(s>=e) return;
        int m = (s+e)/2;
        merge_sort(s,m);
        merge_sort(m+1,e);

        for(int i=s;i<=e;i++){
            tmp[i] = A[i];
        }
        int k=s;
        int idx1 = s;
        int idx2 = m+1;
        while(idx1<=m && idx2<=e){
            if(tmp[idx1]<tmp[idx2]){
                A[k] = tmp[idx1];
                k++;
                idx1+=1;
            }else{
                A[k] = tmp[idx2];
                k++;
                idx2+=1;
            }
        }
        //한쪽 배열정렬이 끝났는 데도 정렬할 것이 남았다면 
        while(idx1<=m){
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2<=e) {
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}