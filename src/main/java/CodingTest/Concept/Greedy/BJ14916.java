package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ14916 {



    public static void main(String [] arg) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        int [] dp = new int [100000+1];
        dp[1]= -1;
        dp[2]=1;
        dp[3]=-1;
        dp[4]= 2;
        dp[5]=1;

        for(int i=6 ; i<=N; i++){
            if(dp[i-5]==-1&& dp[i-2]==0){
                dp[i]= -1;
                continue;
            } else if(dp[i-5]==-1&& dp[i-2]!=0){
                dp[i]= dp[i-2]+1;
                continue;
            } else if(dp[i-5]!=-1&& dp[i-2]==0){
                dp[i]= dp[i-5]+1;
                continue;
            } else{
                dp[i]= Integer.min(dp[i-5], dp[i-2]) +1;
            }
        }

        System.out.println(dp[N]);

    }

}
