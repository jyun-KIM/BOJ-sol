import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean flag=true;
    
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void dfs(){
        Deque<Point> stack = new ArrayDeque<>();
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        //반복문 돌면서 map의 outer side 탐색
        for(int i=0;i<n;i++){
            //0을 만나면 stack에 넣기
            if(map[0][i]==0){
                stack.push(new Point(i,0));
                map[0][i]=1; //방문 처리 
                //dfs 시작
                //stack에 노드가 있다면
                while(!stack.isEmpty()){
                    Point cur = stack.pop();
                    if(cur.y==(m-1)){
                        flag=false;
                        System.out.println("YES");
                        return;
                    }
                    //상하좌우로 next 판단
                    for(int j=0;j<4;j++){
                        int nexty=cur.y+dy[j];
                        int nextx=cur.x+dx[j];
                        if(0<=nexty && nexty<m && 0<=nextx && nextx<n && map[nexty][nextx]==0){
                            stack.push(new Point(nextx, nexty));
                            map[nexty][nextx]=1;
                        }
                    }
                        //!out of index && map[][]=='0'
                        //stack에 넣기 
                        //map[][]='1' 방문표시 
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0;j<n;j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }
        // System.out.println(Arrays.deepToString(map));
        dfs();
        if(flag) System.out.println("NO");
    }
}