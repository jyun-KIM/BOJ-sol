import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //계산해야 하는
        int b = Integer.parseInt(st.nextToken()); //번호
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1]; //촌수 관계를 나타내는 배열
        Deque<Integer> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y]=1;
            map[y][x]=1;
        }

        //a부터 시작해서 탐색
        queue.add(a);
        int answer=0;
        boolean[] visited = new boolean[n+1];
        visited[a]=true;
        boolean flag=true;

        
        //map[a]에 있는 요소들 큐에 넣기
        while(!queue.isEmpty()){  
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                int cur=queue.poll().intValue();
                if(cur==b){
                    flag=false;
                    System.out.println(answer);
                    break;
                }
                for(int j=0; j<map[cur].length; j++){
                    if(map[cur][j]==1 && visited[j]==false){
                        queue.add(j);
                        visited[cur]=true;
                    }
                }
                
            }
            answer++;

        }

        if(flag) System.out.println(-1);
    }
}

