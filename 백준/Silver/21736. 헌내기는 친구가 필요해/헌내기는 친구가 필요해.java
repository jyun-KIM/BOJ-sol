import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] map;
    static int px=0;
    static int py=0; //도연이 위치 저장 
    static int n;
    static int m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int answer=0;
    
    static void dfs(int x, int y){
        if (map[y][x]=='P'){
            answer++;
        }
        map[y][x]='X';
        
        //map범위와 x가 아닌지 확인
        //for(4) dy와 dx만큼 움직임
        for(int i=0;i<4;i++){
            int nextx=x+dx[i];
            int nexty=y+dy[i];
            if(0<=nextx && nextx<m && 0<=nexty && nexty<n && map[nexty][nextx]!='X'){
                dfs(nextx, nexty);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());


        map = new char[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0;j<m;j++){
                map[i][j]=s.charAt(j);
                if(map[i][j]=='I'){                    
                    px=j;
                    py=i;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));

        // //도연이 위치부터 탐색 시작
        dfs(px, py);
        if(answer==0){
            System.out.println("TT");
        }
        else{
            System.out.println(answer);
        }
        
    }
}