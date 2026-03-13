import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    //가로, 세로, (대각선) dxdy
    static int[] dy={-1,1,0,0,-1,-1,1,1};
    static int[] dx={0,0,-1,1,1,-1,1,-1};
    
    static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static void bfs(int[][] map, int curw, int curh, int curx, int cury){
        Deque<Position> queue = new LinkedList<>();
        queue.add(new Position(curx, cury));
        while(!queue.isEmpty()){
            Position cur=queue.poll();
            //가로, 세로, 대각선에 1이 있는지 확인하며 탐색 시작
            for(int i=0;i<8;i++){
                int nexty=cur.y+dy[i];
                int nextx=cur.x+dx[i];
                if(0<=nexty && nexty<curh && 0<=nextx && nextx<curw && map[nexty][nextx]==1){
                    queue.add(new Position(nextx, nexty));
                    map[nexty][nextx]=2; //visited 처리
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //while true
        while (true) {
            int answer=0;
            st = new StringTokenizer(br.readLine());
            //w,h 입력 받기
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());     
            //0,0이면 종료
            if(w==0 && h==0) break;
            //for i,j 2차원 배열에 map 입력받기 
            map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            //map 전체를 돌면 방문 안 한 곳을 찾을 때마다 bfs
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j]==1){
                        answer++;
                        // System.out.println(Arrays.deepToString(map));
                        bfs(map,w,h,j,i);
                    }
                }
            }
            System.out.println(answer);
            
            
        }
    }
}