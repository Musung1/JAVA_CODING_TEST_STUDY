package dataStructure.연습장.힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(maxq.size() == minq.size()) maxq.add(k);
            else minq.add(k);
            if(!maxq.isEmpty() && !minq.isEmpty()) {
                if(maxq.peek() > minq.peek()) {
                    maxq.add(minq.poll());
                    minq.add(maxq.poll());
                }
            }
            System.out.println(maxq.peek());
        }

    }
}