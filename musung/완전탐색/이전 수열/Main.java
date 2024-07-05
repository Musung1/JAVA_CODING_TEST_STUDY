import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        if(hasPrePerm()) {
            for(int i = 0; i < n; i ++) {
                System.out.print(nums[i] + " ");
            }

        } else {
            System.out.println(-1);
        }
    }
    public static boolean hasPrePerm() {
        int i = n-1;
        while(i > 0 && nums[i-1] < nums[i])i--;
        if(i == 0) return false;
        int j = n-1;
        while(nums[i-1] < nums[j]) j--;
        swap(i-1,j);
        j = package dataStructure.연습장.힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
        class Main {
            static int n;
            static int[] nums;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                nums = new int[n];
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(st.nextToken());
                }
                if(hasPrePerm()) {
                    for(int i = 0; i < n; i ++) {
                        System.out.print(nums[i] + " ");
                    }

                } else {
                    System.out.println(-1);
                }
            }
            public static boolean hasPrePerm() {
                int i = n-1;
                while(i > 0 && nums[i-1] < nums[i])i--;
                if(i == 0) return false;
                int j = n-1;
                while(nums[i-1] < nums[j]) j--;
                swap(i-1,j);
                j = n-1;
                while(i-1 < j) {
                    swap(i,j);
                    i++;
                    j--;
                }
                return true;
            }
            private static void swap(int a , int b) {
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            }
        }n-1;
        while(i-1 < j) {
            swap(i,j);
            i++;
            j--;
        }
        return true;
    }
    private static void swap(int a , int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}