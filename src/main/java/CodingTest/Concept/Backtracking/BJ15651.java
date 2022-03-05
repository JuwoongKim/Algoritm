package CodingTest.Concept.Backtracking;

import java.util.*;
import java.io.*;

public class BJ15651 {

    public static int N;
    public static int M;
    public static int [] route;
    public static boolean [] isVisited;
    public static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BJ15651 T =new BJ15651();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new int [M];
        isVisited = new boolean [N+1];
        T.DFS(0);
        System.out.println(sb);
    }

    public void DFS(int level){

        if(level ==M){
            for(int ele : route)
                sb.append(ele + " ");
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N ; i++) {
            route[level] = i;
            DFS(level+1);
        }

    }
}
