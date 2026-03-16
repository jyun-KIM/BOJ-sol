import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] board = new int[5][5];
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean flag = false;
    
    static void dfs(int r, int c, int moves, int apples){
        if (apples==2){
            flag = true;
            return;
        }
        if (apples<2 && moves==3){
            return;
        }
        int temp=board[r][c];
        board[r][c]=-1;

        //상하좌우로 가면서 탐색 
        for(int i=0;i<4;i++){
            int cy=r+dy[i];
            int cx=c+dx[i];
            if(0<=cy && cy<5 && 0<=cx && cx<5 && board[cy][cx]!=-1){
                if(board[cy][cx]==1){
                    dfs(cy,cx,moves+1,apples+1);
                } else{
                    dfs(cy,cx,moves+1,apples);
                }
                if(flag) break;
            }  
        }
        board[r][c]=temp;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //보드 초기화 
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(board));
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); 

        dfs(r,c,0,0);
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}