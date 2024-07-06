package dataStructure.연습장.힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n;
    static int[] dp;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] =Integer.parseInt(st.nextToken());
            dp[i+1] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(board[j-1] < board[i-1] && dp[j] + 1 > dp[i] ) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
        // 가장 긴 수열에 마지막 수가 들어갈지 말지로

    }
}