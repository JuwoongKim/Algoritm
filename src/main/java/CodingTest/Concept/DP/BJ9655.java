package CodingTest.Concept.DP;

import java.util.*;
import java.io.*;
public class BJ9655 {

    public static void main (String [] arg) throws IOException{

        BJ9655 T = new BJ9655();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        T.solution(N);
    }

    public void solution(int N){

        String [] memo = new String [N+1];
        String answer = DFS(N, memo);
        System.out.println(answer);
    }

    public String DFS(int N, String [] memo){

        if(N==1|| N ==3){
            memo[N] = "SK";
            return memo[N];
        }else if(N==2){
            memo[N] ="CY";
            return memo[N];
        }else{
            memo[N]=DFS(N-2, memo);
            return  memo[N];
        }
    }

}
