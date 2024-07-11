import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n,m;
    static int[][] board;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<int[]> arr = new ArrayList<>();
    static int count = 0;
    static int num;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = n*m;
        board = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] =  Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    num--;
                }
                if(board[i][j] == -1) {
                    num--;
                }
            }
        }
        bfs();
        System.out.println(count);
    }
    // bfs -> 맨 처음 것 넣음 , count++, 다음 큥 끝나면 count++ ,... 모두 visit하면 count return
    public static void bfs() {
        while(num != 0) {
            queue.addAll(arr);
            arr.clear();
            if(queue.isEmpty() && num != 0) {
                count = -1;
                return;
            }
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx < 0 || nx >= m) continue;;
                    if(ny < 0 || ny >= n) continue;
                    if(board[nx][ny] != 0) continue;
                    board[nx][ny] = 1;
                    num--;
                    arr.add(new int[]{nx,ny});
                }
            }
            count++;
        }
    }

}