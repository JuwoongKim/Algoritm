package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;
public class BJ1010 {

    public static int answer;
    public static int[] arr;

    public static void main(String[] arg) throws IOException {

        BJ1010 T = new BJ1010();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            T.solution(east, west);
        }
    }

    public void solution(int east, int west) {
        int [][] memo = new int [east+1][west+1];
        int answer = DFS(east, west,memo);
        System.out.println(answer);
    }

    public int DFS(int n, int r, int [][] memo) {

        if (memo[n][r] != 0) return memo[n][r];
        else {
            if (r == 0 || n == r) {
                memo[n][r] = 1;
                return memo[n][r];
            }
            memo[n][r]= DFS(n - 1, r - 1, memo) + DFS(n - 1, r, memo);
            return memo[n][r];
        }
    }
}


















