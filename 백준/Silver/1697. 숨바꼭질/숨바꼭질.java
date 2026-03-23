import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        //queue n을 넣음
        queue.add(n);
        //n 방문 처리
        visited[n]=true;
        int time=0;
        //queue 빌 때까지 
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                if(cur==k){
                    System.out.println(time);
                    return;
                }
            
                //-1, +1, *2인 위치를 각각 구해서
                int plus = cur+1;
                int minus = cur-1;
                int mul = cur*2;
                //범위, 방문여부 살핀 후 
                if(0<=plus && plus<100001 && visited[plus]==false){
                    queue.add(plus);
                    visited[plus]=true;
                }
                if(0<=minus && minus<100001 && visited[minus]==false){
                    queue.add(minus);
                    visited[minus]=true;
                }
                if(0<=mul && mul<100001 && visited[mul]==false){
                    queue.add(mul);
                    visited[mul]=true;
                }
                // System.out.printf("time: %d, cur: %d\n", time, cur);
            }
            time++;
            //조건 맞으면 큐에 넣음 
        }
    }
}