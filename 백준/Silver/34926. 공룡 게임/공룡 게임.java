import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        char[] map = new char[n];
        st = new StringTokenizer(br.readLine());
        // System.out.println(st.nextToken());
        String line = st.nextToken();

        for(int i=0; i<n; i++){
            map[i]=line.charAt(i);
        }
        // System.out.println(Arrays.toString(map));
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0); //큐에는 map의 인덱스를 집어넣음 
        int flag=0;

        while(!queue.isEmpty()){
            int cur = queue.poll().intValue(); //방문할 map의 인덱스
            if (cur==(n-1)){
                System.out.println("YES");
                flag=1;
                break;
            }
            //범위&&!방문
            if(cur+1<n){

                //큐에 넣기 전에 장애물 아닌지 확인 
                //cur+k<n 이라면 cur+k도 큐에 넣기
                if(cur+k < n && map[cur+k]!='#' && visited[cur+k]==false){
                    queue.add(cur+k);
                    visited[cur+k]=true;
                }
                if(map[cur+1]!='#' && visited[cur+1]==false){
                    queue.add(cur+1);
                    visited[cur+1]=true;
                }
                
            }
        }
        if(flag==0) System.out.println("NO");
    }
}