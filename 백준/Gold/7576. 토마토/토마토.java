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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] storage = new int[n][m];
        int[] dy={-1,1,0,0};
        int[] dx={0,0,-1,1};
        //queue선언
        Deque<Position> queue = new LinkedList<>();
        //int[][] 초기화 하면서 1의 위치 넣어두기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                storage[i][j]=Integer.parseInt(st.nextToken());
                if(storage[i][j]==1) {
                    queue.add(new Position(j,i));
                }
            }
        }
        // System.out.println(Arrays.deepToString(storage));
        //큐가 빌 때까지
        while(!queue.isEmpty()){
            int size = queue.size();
            //stack size만큼 for문
            for(int i=0;i<size;i++){
                //cur=
                Position cur=queue.poll();
                //cur의 상하좌우 방문
                for(int j=0;j<4;j++){
                    int nx=cur.x+dx[j];
                    int ny=cur.y+dy[j];
                    if(0<=nx && nx<m && 0<=ny && ny<n && storage[ny][nx]==0){
                        queue.add(new Position(nx,ny));
                        storage[ny][nx]=storage[cur.y][cur.x]+1;
                    }
                }
                //범위내 && !방문
                //cur의 값보다 +1로 바꾸기 (날짜+1)
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                if(storage[i][j]==0){
                    System.out.println(-1);
                    return;
                } else if(storage[i][j]>max){
                    max=storage[i][j];
                }
            }
        }
        System.out.println(max-1);
    }
}