import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int answer=1;

        //큐 선언, add(a)
        Deque<Long> queue = new LinkedList<>();
        queue.add(a);
        //visited[a]=true
        // boolean[] visited = new boolean[b-a+1];
        // visited[0]=true; //a-a
        boolean flag=true;

        //큐가 빌 때까지
        while(!queue.isEmpty()){
            //size=queue.size()
            int size=queue.size();
            //for size
            for(int i=0;i<size;i++){
                // System.out.println(answer);
                //cur=poll()
                long cur=queue.poll();
                // System.out.println(cur);
                if(cur==b){
                    System.out.println(answer);
                    flag=false;
                    return;
                }
                if(cur*2<=b){
                    queue.add(cur*2);
                    // visited[cur*2-a]=true;
                }
                if(cur*10+1<=b){
                    queue.add(cur*10+1);
                    // visited[cur*10+1-a]=true;
                }
                //if cur==b break

                //큐.add(cur*2)
                //큐.add(cur*10+1)
                //둘 다 visited=true
            //answer+=1
            }
            answer+=1;
        }
        if(flag) System.out.println(-1);
    }
}