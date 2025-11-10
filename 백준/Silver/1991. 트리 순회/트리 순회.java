import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Node[] tree;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        //초기화
        tree = new Node[N];

        //입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[parent-'A'] = new Node(left, right);
        }

        //전위
        preorder('A');
        bw.newLine();

        //중위
        inorder('A');
        bw.newLine();

        //후위
        postorder('A');
        bw.newLine();

        bw.close();
    }

    private static class Node{
        private char left;
        private char right;
        Node(char left, char right){
            this.left = left;
            this.right = right;
        }
    }

    private static void preorder(char current) throws IOException {
        if(current == '.') return;
        bw.write(current);

        int currentIdx = current-'A';
        preorder(tree[currentIdx].left);
        preorder(tree[currentIdx].right);
    }

    private static void inorder(char current) throws IOException {
        if(current == '.') return;

        int currentIdx = current-'A';
        inorder(tree[currentIdx].left);

        bw.write(current);


        inorder(tree[currentIdx].right);
    }

    private static void postorder(char current) throws IOException {
        if(current == '.') return;

        int currentIdx = current-'A';
        postorder(tree[currentIdx].left);
        postorder(tree[currentIdx].right);
        bw.write(current);

    }
}
