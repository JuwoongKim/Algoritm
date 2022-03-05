package CodingTest.Concept.Backtracking;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class BJ15650 {

    public static int N;
    public static int M;
    public static int [] route;
    public static boolean [] isVisited;

    public static void main(String[] args) throws IOException{

        BJ15650 T =new BJ15650();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new int [M];
        isVisited = new boolean [N+1];
        T.DFS(0);
    }

    public void DFS(int level){

        if(level ==M){
            for(int ele : route)
                System.out.print(ele + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N ; i++) {

            if( !isVisited[i]){

                if(level >= 1 && i<route[level-1]) continue;

                isVisited[i] =true;
                route[level] = i;
                DFS(level+1);
                isVisited[i] = false;
            }
        }

    }
}
