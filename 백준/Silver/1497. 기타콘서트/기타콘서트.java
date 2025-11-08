import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] masks = new long[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] name = st.nextToken().toCharArray();
            char[] mask = st.nextToken().toCharArray();
            long bitmask = 0L;

            for(char a:mask) {
                bitmask = bitmask << 1; //왼쪽으로 한 칸 밀기
                if(a=='Y'){
                    bitmask = bitmask | 1;
                }
            }
            masks[i] = bitmask;
        }

        int answer = 11;
        long maxSongs = 0;

        for(int i=1; i<=(1<<N); i++) {
            long combiedMask = 0;
            int usedGuitars = 0;

            for(int j=0;j<N;j++){
                if((i & (1<<j)) != 0){ //i 방법에 j번째 기타가 사용됨
                    combiedMask |= masks[j];
                    usedGuitars++;
                }
            }
            int currentSongs = Long.bitCount(combiedMask);
            if(currentSongs > maxSongs){
                maxSongs = currentSongs;
                answer = usedGuitars;
            }else if((currentSongs == maxSongs) && (answer>usedGuitars)){
                answer = usedGuitars;
            }

        }

        if(maxSongs == 0){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
}