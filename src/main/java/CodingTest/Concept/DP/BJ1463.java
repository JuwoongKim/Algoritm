package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;
public class BJ1463 {

    public static void main (String [] arg) throws IOException{

        BJ1463 T = new BJ1463();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int [N+1];

        for(int i =2; i<=N; i++){
            List<Integer> list = new ArrayList<>();
            if(i%3==0) list.add(dp[i/3]);
            if(i%2==0) list.add(dp[i/2]);
            list.add(dp[i-1]);
            dp[i] = Collections.min(list) +1;
        }
        System.out.println(dp[N]);

    }
}
