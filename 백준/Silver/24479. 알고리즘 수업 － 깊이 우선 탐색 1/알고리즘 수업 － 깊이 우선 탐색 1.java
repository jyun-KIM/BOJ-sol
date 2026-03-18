import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count=0;
    static int[] answer;
    
    static void dfs(int cur){
        visited[cur]=true;
        count++;
        answer[cur]=count;
        for (int next: graph[cur]){
            if(visited[next]==false){
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        //graph 초기화
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        // System.out.println(graph.toString);
        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }
        visited=new boolean[n+1];
        answer = new int[n+1];
        dfs(r);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

}