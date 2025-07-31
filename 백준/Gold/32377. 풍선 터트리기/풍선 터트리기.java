import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        long l = 1, r = (long) 1e18;

        while(l < r){
            long m = (l+r)/2;
            long total = m/x + m/y + m/z;
            if(total >= n) r=m;
            else if(total < n) l=m+1; 
        }

        long t = l;
        long total = t/x + t/y + t/x;
        List<Character> list = new ArrayList<>();
        if (t % x == 0) list.add('A');
        if (t % y == 0) list.add('B');
        if (t % z == 0) list.add('C');

        long before = (t - 1) / x + (t - 1) / y + (t - 1) / z;
        int diff = (int)(n - before);  

        System.out.println(list.get(diff - 1) + " win");

        
    }
}
