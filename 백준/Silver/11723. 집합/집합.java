import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value;

            switch (command) {
                case "add":
                    value = Integer.parseInt(st.nextToken());
                    bitmask |= (1<<value);
                    break;
                case "remove":
                    value = Integer.parseInt(st.nextToken());
                    bitmask &= ~(1<<value);
                    break;
                case "check":
                    value = Integer.parseInt(st.nextToken());
                    if((bitmask & (1<<value)) != 0) {
                        sb.append("1").append("\n");
                    }else sb.append("0").append("\n");
                    break;
                case "toggle":
                    value = Integer.parseInt(st.nextToken());
                    bitmask ^= (1<<value);
                    break;
                case "all":
                    bitmask |= (1<<21)-1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
