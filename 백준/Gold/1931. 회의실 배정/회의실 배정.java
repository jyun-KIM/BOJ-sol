import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Pair {
        int s, e;
        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            pairs.add(new Pair(s,e));
        }

        pairs.sort((a,b)->{
            if(a.e != b.e) return a.e-b.e;
            return a.s-b.s;
        });

        int ans=1; int start=pairs.get(0).s; int end=pairs.get(0).e;
        for(int i=1;i<n;i++){
            if(end<=pairs.get(i).s) {
                ans++;
                start=pairs.get(i).s; end=pairs.get(i).e;
            }
        }
        System.out.println(ans);
            
    }
}