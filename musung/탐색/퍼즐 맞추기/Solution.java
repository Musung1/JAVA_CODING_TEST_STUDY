import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
class Solution {
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{-1,0,1,0};
    static ArrayList<ArrayList<Node>> Garr;
    static ArrayList<ArrayList<Node>> Tarr;
    public int solution(int[][] game_board, int[][] table) {
        Garr = new ArrayList<>();
        Tarr = new ArrayList<>();
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board[0].length; j++) {
                if(game_board[i][j] == 1) continue;
                bfsG(new Node(j,i),game_board);
            }
        }
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[0].length; j++) {
                if(table[i][j] == 0) continue;
                bfsT(new Node(j,i),table);
            }
        }
        int answer = compare(Garr,Tarr);
        return answer;
    }
    public int compare(ArrayList<ArrayList<Node>> board, ArrayList<ArrayList<Node>> table) {
        boolean[] visitedB = new boolean[board.size()];
        boolean[] visitedT = new boolean[table.size()];
        int count = 0;
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < table.size(); j++) {
                if(visitedB[i]) continue;
                if(visitedT[j]) continue;
                if(board.get(i).size() != table.get(j).size()) continue;
                if(i == 3) System.out.println("hi");
                if(isSame(board.get(i),table.get(j))) {
                    visitedB[i] = true;
                    visitedT[j] = true;
                    //System.out.println(i);
                    //System.out.println(table.get(j).size());
                    count += board.get(i).size();
                }
            }
        }
        return count;
    }
    public boolean isSame(ArrayList<Node> o1, ArrayList<Node> o2) {
        Collections.sort(o1,(a,b)-> {
            if(a.x == b.x) return a.y - b.y;
            return a.x - b.x ;
        });
        int cur1X = o1.get(0).x;
        int cur1Y = o1.get(0).y;
        for(int j = 0; j < o1.size(); j++) {
            o1.get(j).x -= cur1X;
            o1.get(j).y -= cur1Y;
        }
        for(int i = 0; i < 4; i++) {
            Collections.sort(o2,(a,b)-> {
                if(a.x == b.x) return a.y - b.y;
                return a.x - b.x ;
            });
            int curX = o2.get(0).x;
            int curY = o2.get(0).y;
            for(int j = 0; j < o2.size(); j++) {
                o2.get(j).x -= curX;
                o2.get(j).y -= curY;
            }
            boolean check = true;
            //1. 서로 같으면 return true;
            for(int j = 0; j < o1.size(); j++) {
                if(o1.get(j).x != o2.get(j).x || o1.get(j).y != o2.get(j).y) {
                    check = false;
                    break;
                }
            }
            if(check) return true;
            else {
                for(int j=0; j<o2.size(); j++){
                    int temp = o2.get(j).x;
                    o2.get(j).x = o2.get(j).y;
                    o2.get(j).y = -temp;
                }
            }
        }
        return false;
    }
    public void bfsG(Node root,int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        queue.add(root);
        int rootX = root.x;
        int rootY = root.y;
        nodes.add(new Node(0,0));
        board[rootY][rootX] = 1;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX < 0 || nextX > board[0].length-1) continue;
                if(nextY < 0 || nextY > board.length-1) continue;
                if(board[nextY][nextX] == 1) continue;
                queue.add(new Node(nextX,nextY));
                nodes.add(new Node(nextX - root.x, nextY - root.y));
                board[nextY][nextX] = 1;
            }
        }
        Garr.add(nodes);
    }
    public void bfsT(Node root,int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        queue.add(root);
        int rootX = root.x;
        int rootY = root.y;
        nodes.add(new Node(0,0));
        board[rootY][rootX] = 0;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX < 0 || nextX > board[0].length-1) continue;
                if(nextY < 0 || nextY > board.length-1) continue;
                if(board[nextY][nextX] == 0) continue;
                queue.add(new Node(nextX,nextY));
                nodes.add(new Node(nextX - root.x, nextY - root.y));
                board[nextY][nextX] = 0;
            }
        }
        Tarr.add(nodes);
    }
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

