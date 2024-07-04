import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
class Main {
    static boolean[] visited;
    static int[][] schedule;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Character> arr = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        schedule = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        backTracking(0,0);
        System.out.println(max);

    }
    public static void backTracking(int days, int sum) {
        max = Math.max(max,sum);
        for(int i = days; i < n; i++) {
            if(visited[i]) continue;
            if(i + schedule[i][0] > n) continue;
            visited[i] = true;
            backTracking(i + schedule[i][0], sum + schedule[i][1]);
            visited[i] = false;
        }
    }

}