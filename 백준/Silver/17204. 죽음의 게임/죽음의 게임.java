import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bs = Integer.parseInt(st.nextToken());

        int[] order = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            order[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int answer=1;
        stack.push(order[0]);
        while(answer<n){
            int cur=stack.pop();
            if(cur==bs){
                System.out.println(answer);
                return;
            }
            stack.push(order[cur]);
            answer++;
        }
        System.out.println(-1);
    }
}