import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n;
    static int[] board;
    static int[] dp1,dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
            dp1[i] = board[i];
            dp2[i] = board[i];
        }
        for(int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i],dp1[i-1] + board[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i],dp2[i+1] + board[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max,dp1[i]);
        }
        for(int i = 1; i < n-1; i++) {
            if( dp1[i-1] + dp2[i+1] > max) {
                max = Math.max(dp1[i-1] + dp2[i+1], max);
            }
        }
        System.out.println(max);
    }
}