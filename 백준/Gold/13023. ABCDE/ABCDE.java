import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n];
        visited = new boolean[n];
        arrive = false;

        for(int i=0; i<n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for(int i=0; i<n; i++) {
            DFS(i,1);
            if(arrive) break;
        }

        if(arrive){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

    static void DFS(int now, int depth) {
        if(depth==5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i:A[now]) {
            if(!visited[i]){
                DFS(i, depth+1);
            }
        }
        visited[now] = false;
    }
}