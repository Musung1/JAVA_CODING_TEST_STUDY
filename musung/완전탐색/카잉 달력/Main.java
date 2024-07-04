package dataStructure.연습장.힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(find(p,k,x,y));
        }
    }
    public static int find(int p, int k, int x, int y) {
        for(int i = 0; i <= k; i++) {
            int s = i * p + x;
            int e = (s-1) % k + 1;
            if(y == e) return s;
            if(s == p && e == k) return -1;
        }
        return -1;
    }
}