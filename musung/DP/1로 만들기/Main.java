햣 ㅎimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            long min = Long.MAX_VALUE;
            if(i % 3 == 0) {
                min = Math.min(min,dp[i/3] + 1);
            }
            if(i % 2 == 0) {
                min = Math.min(min,dp[i/2] + 1);
            }
            min = Math.min(min,dp[i-1] + 1);
            dp[i] = min;
        }
        System.out.println(dp[n]);


    }

}