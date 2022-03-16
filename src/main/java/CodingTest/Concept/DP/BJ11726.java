package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;

public class BJ11726 {

    public static void main(String [] arg) throws IOException{

        BJ11726 T = new BJ11726();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int [N+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007; // 나머지 연산을 해줘야하는 이유
        }
        System.out.println(dp[N]);
    }
}
