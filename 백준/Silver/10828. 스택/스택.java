import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new LinkedList<>();

        for (int i=0; i<n; i++){
            String line=br.readLine();
            StringTokenizer st=new StringTokenizer(line);
            String command = st.nextToken();

            if (command.equals("push")){
                int value=Integer.parseInt(st.nextToken());
                stack.push(value);
            }else if (command.equals("pop")){
                bw.write((stack.isEmpty()?-1+"\n":stack.pop()+"\n"));
            }else if (command.equals("size")){
                bw.write(stack.size()+"\n");
            }else if (command.equals("empty")){
                if (stack.isEmpty()) bw.write(1+"\n"); else bw.write(0+"\n");
            }else{
                bw.write((stack.isEmpty()?-1+"\n":stack.peek()+"\n"));
            }
        }
        bw.flush();
        bw.close();
        
    }
}