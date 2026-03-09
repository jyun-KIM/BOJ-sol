import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n= m=
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        //int[m][n] 초기화
        int[][] map = new int[m][n];
        for (int i=0;i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());;
            }
        }
        // System.out.println(Arrays.deepToString(map));

        //queue 선언
        Deque<Position> queue = new LinkedList<>();
        //queue에 위치 (0,0) 넣음 > Position class 생성
        queue.add(new Position(0,0));
        //visited 배열 생성
        boolean[][] visited = new boolean[m][n];
        boolean flag=false;
        //while queue
        while(!queue.isEmpty()){
            Position cur = queue.poll();
            if(cur.x==(n-1) && cur.y==(m-1)){ 
                System.out.println("Yes");
                flag=true;
                break;
            }
            if(cur.x<n-1 && cur.y<m && visited[cur.y][cur.x+1]==false && map[cur.y][cur.x+1]==1){
                queue.add(new Position(cur.x+1, cur.y));
                visited[cur.y][cur.x+1]=true;
            }
            if(cur.x<n && cur.y<m-1 && visited[cur.y+1][cur.x]==false && map[cur.y+1][cur.x]==1){
                queue.add(new Position(cur.x, cur.y+1));
                visited[cur.y+1][cur.x]=true;
            }
        }
        //하나 poll
        //x,y가 m,n 이 아니라면 진행. 맞으면 break
        //x+1, y+1을 각각 queue에 넣음. visited=true
        if(!flag){
            System.out.println("No");
        }
        
    }
}