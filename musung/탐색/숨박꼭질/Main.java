package dataStructure.연습장.힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n,k;
    static int count = 0;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs(n);
        System.out.println(count);

    }
    public static void bfs(int root) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{root,0});
        set.add(root);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == k) {
                count = cur[1];
                return;
            }
            if(!set.contains(cur[0] -1) && cur[0] - 1 >= 0 && cur[0] - 1 <= 200_000) {
                queue.add(new int[]{cur[0]-1,cur[1] + 1});
                set.add(cur[0]-1);
            }
            if(!set.contains(cur[0]+1)  && cur[0] + 1 >= 0 && cur[0] + 1 <= 200_000 ) {
                queue.add(new int[]{cur[0]+1,cur[1] + 1});
                set.add(cur[0]+1);
            }
            if(!set.contains(cur[0]*2) && cur[0]*2 >= 0 && cur[0]*2 <= 200_000) {
                queue.add(new int[]{cur[0]*2,cur[1] + 1});
                set.add(cur[0]*2);
            }

        }
    }

}