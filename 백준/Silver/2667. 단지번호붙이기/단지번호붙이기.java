import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int num=2;
    static int[][] map;
    static int n;
    static int[] answer;
    
    static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static void dfs(int x, int y){
        Deque<Position> stack = new ArrayDeque<>();
        stack.push(new Position(x,y));
        int[] dy={-1,1,0,0};
        int[] dx={0,0,-1,1};
        //첫시작점 방문표시
        map[y][x]=num;
        //stack이 빌 때까지
        while(!stack.isEmpty()){
            Position cur = stack.pop();
            //answer배열에 숫자 증가 
            answer[num]+=1;
            //for(4)
            for(int i=0;i<4;i++){
                //nextx=? nexty=?
                int nextx=cur.x+dx[i];
                int nexty=cur.y+dy[i];
                //next가 범위 안에 있고 방문 전이라면
                if(0<=nextx && nextx<n && 0<=nexty && nexty<n && map[nexty][nextx]==1){
                    //stack에 넣기 
                    stack.push(new Position(nextx, nexty));
                    //num으로 바꾸기 
                    map[nexty][nextx]=num;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        answer = new int[n*n+2]; //7x7+2=51까지 

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0;j<n;j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }
        // System.out.println(Arrays.deepToString(map));

        //map을 하나씩 돌며 dfs 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1){
                    dfs(j,i);
                    num++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        // System.out.println(Arrays.toString(answer));

        int ans=0;
        Arrays.sort(answer);
        for(int a:answer){
            if(a!=0){
                ans++;
                bw.write(String.valueOf(a));
                bw.newLine();
            }
        }
        System.out.println(ans);
        bw.flush();
    }
}