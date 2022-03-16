package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;

public class BJ2579 {

    public static void main (String [] arg)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int [300 +1];  //입력조건에 따른 런타임 에러 방지
        int [] stair = new int [N+1];
        for(int i =1; i<=N; i++) stair[i] = Integer.parseInt(br.readLine());

        dp[1]=stair[1];
        dp[2]= stair[1]+ stair[2];
        dp[3] = Integer.max(stair[1], stair[2]) +stair[3];

        for(int i =4 ; i <=N; i++){
            dp[i] = Integer.max(dp[i-3]+stair[i-1], dp[i-2]) + stair[i];
        }
        System.out.println(dp[N]);
    }

}


