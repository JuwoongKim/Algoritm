package CodingTest.Concept.Backtracking;

import java.io.*;
import java.util.*;

public class BJ15649 {

    public static boolean [] isVisited;
    public static int  [] answerArr;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException{

        BJ15649 T = new BJ15649();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean [N+1];
        answerArr = new int [M];
        T.DFS(0);
    }

    public void DFS(int level){

        if(level ==M){
            for(int i=0; i< answerArr.length ; i++)
                System.out.print(answerArr[i]+ " ");
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(isVisited[i]) continue;

            answerArr[level] = i;
            isVisited[i] = true;
            DFS(level+1);
            isVisited[i]=false;
        }
    }
}
