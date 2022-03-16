package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;

public class BJ11727 {


    public static void main (String [] arg) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int [1000+1];
        dp[1]= 1;
        dp[2]= 3;

        for(int i =3; i<=N ; i++){
            dp[i] = (dp[i-1]  +(2*dp[i-2]))%10007;
        }
        System.out.println(dp[N]);

    }

}
