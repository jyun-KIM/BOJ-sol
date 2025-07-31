import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Pair{
            int idx;
            int incl;
    
            Pair(int idx, int incl){
                this.idx=idx;
                this.incl=incl;
            }
        }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        List<Pair> A = new ArrayList<>();

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int incl = y2-y1;
            if (incl > 0) A.add(new Pair(x1, 1));
            else if (incl < 0) A.add(new Pair(x1, -1));
            else A.add(new Pair(x1, 0));
            x1=x2;
            y1=y2;

        }

        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            double q = Double.parseDouble(br.readLine());
            search(A,q);
        }
        
    }
    private static void search(List<Pair> A, double q){
        int l=0;
        int r=A.size()-1;
        while (l<=r) {
            int m = (l+r)/2;
            int curX = A.get(m).idx;
            int nextX = (m+1 < A.size()) ? A.get(m+1).idx : Integer.MAX_VALUE;
            if(curX<q && q<nextX) {
                System.out.println(A.get(m).incl);
                return;
            }
            else if(q<=curX) r=m-1;
            else l=m+1;
        }
    }

    
}