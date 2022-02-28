package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;

public class BJ2839 {


    public static void main(String [] arg) throws IOException{

        BJ2839 T = new BJ2839();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T.solution(n);

    }
    public void solution(int n){

        int []memo;
        if(n<5) memo = new int[6];
        else memo = new int[n+1];

        Arrays.fill(memo, Integer.MAX_VALUE);
        if (n<3) throw new IllegalArgumentException();


        memo[3]=1;
        memo[5]=1;
        for(int i =6;i<=n; i++){

            if(memo[i-3]==Integer.MAX_VALUE && memo[i-5] ==Integer.MAX_VALUE) continue;
            else {
                memo[i] = Integer.min(memo[i - 3], memo[i - 5]) + 1;
            }
        }
        if(memo[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(memo[n]);

    }
}
