package CodingTest.Concept.DP;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BJ2407 {

    public static void main (String [] arg) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger[][] dp =  new BigInteger [100+1][100+1];

        for(int n=1; n<=N; n++){
            for(int m=0; m <=M; m++){
                if(m>n) break;
                if(n==m || m==0) dp[n][m]=new BigInteger("1");
                else dp[n][m]= dp[n-1][m-1].add(dp[n-1][m]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
