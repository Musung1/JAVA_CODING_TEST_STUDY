import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n;
    static int[][] upDP;
    static int[][] downDP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] board = new int[n+1];
        upDP = new int[n+1][2];
        downDP = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            upDP[i][0] = 1;
            downDP[i][0] = 1;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(board[i] > board[j]) {
                    if(upDP[i][0] < upDP[j][0] + 1) {
                        upDP[i][0] = upDP[j][0] + 1;
                        upDP[i][1] = j;
                    }
                }
            }
        }
        for(int i = n; i > 0; i--) {
            for(int j = n; j > i; j--) {
                if(board[i] > board[j]) {
                    if(downDP[i][0] < downDP[j][0] + 1) {
                        downDP[i][0] = downDP[j][0] + 1;
                        downDP[i][1] = j;
                    }
                }
            }
        }
        int max = 0;
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            if(max < upDP[i][0] + downDP[i][0]) {
                max = upDP[i][0] + downDP[i][0];
                idx = i;
            }
        }
        ArrayList<Integer> upArr = new ArrayList<>();
        ArrayList<Integer> downArr = new ArrayList<>();
        int cur = idx;
        while(cur > 0) {
            upArr.add(upDP[cur][0]);
            cur = upDP[cur][1];
        }
        cur = downDP[idx][1];
        while(cur > 0) {
            downArr.add(downDP[cur][0]);
            cur = downDP[cur][1];
        }
//        for(int i = upArr.size()-1; i >= 0; i--) {
//            System.out.print(upArr.get(i) + " ");
//        }
//        for(int i = 0; i < downArr.size(); i++) {
//            System.out.print(downArr.get(i) + " ");
//        }
        System.out.println(max-1);
    }
}