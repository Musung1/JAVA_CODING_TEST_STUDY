ㅎimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n,k;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new long[n+10][k+10];
        dp[0][1] = 1;
        dp[1][1] = 1;

        for(int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for(int i = 0; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                for(int y = 0; y <= i; y++) {
                    dp[i][j] += dp[y][j-1];
//                    System.out.printf("dp[%d][%d] += dp[%d][%d] ,%d",i,j,y,j-1,dp[y][j-1]);
//                    System.out.println();
                }
                dp[i][j] = dp[i][j]  % 1_000_000_000;
//                System.out.println();
            }
        }
        System.out.println(dp[n][k]% 1_000_000_000);
    }
    //dp[3][2] = dp[2][1] + dp[1][1] , dp[1][1] + dp[2][1];
    // 12 21
    // dp[4][2] = 13 22 31
    // dp[5][3] == dp[1][2] [2][2] [3][2] [4][2]
    //
    // dp[4][1] -> dp[4][2]
    // -> dp[3][1] + dp[1][1] , dp[2][1] + dp[1][2] ..
    // dp[4][1] -> dp[4][3]
    // dp[4]
    // dp[20][2] = dp[1][1] + dp[19][1];

    // [6][4] = [3][3],3 | [4][3],2 | [5][3],1
}