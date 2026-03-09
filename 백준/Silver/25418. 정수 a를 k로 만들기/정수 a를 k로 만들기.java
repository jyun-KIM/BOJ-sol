import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        queue.add(a);
        int answer=0;
        visited[a]=true;
        //while queue
        while (!queue.isEmpty()){
            //depth에 몇 개의 노드가 있는지 확인
            int size=queue.size();
            for (int i=0;i<size; i++){
                //하나 빼기
                int cur=queue.poll();
                if (cur==k) {
                    System.out.println(answer);
                    return;
                }
                //queue에 +1과 x2한 것 넣기
                if (cur+1 <= 1000000 && visited[cur+1]==false){
                    queue.add(cur+1);
                    visited[cur+1]=true;
                }
                if (cur*2 <= 1000000 && visited[cur*2]==false){
                    queue.add(cur*2);
                    visited[cur*2]=true;
                }
            }
            answer++;
            
        }
        
    }
}