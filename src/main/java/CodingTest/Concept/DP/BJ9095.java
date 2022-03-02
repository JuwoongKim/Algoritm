package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;

public class BJ9095 {

    public static void main(String [] arg) throws IOException{

        BJ9095 T = new BJ9095();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int [] dp = new int [12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i =0; i<num; i++){
            int N = Integer.parseInt(br.readLine());


            for(int j=4 ; j<=N ; j++){
                dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]);
            }
            System.out.println(dp[N]);
        }
    }
}
