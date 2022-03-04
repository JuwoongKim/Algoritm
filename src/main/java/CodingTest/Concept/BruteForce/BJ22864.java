package CodingTest.Concept.BruteForce;

import java.io.*;
import java.util.*;

public class BJ22864 {

    public static void main(String [] arg) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = stoi(st.nextToken());
        int B = stoi(st.nextToken());
        int C = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        long totalWork=0;
        long currentTired=0;
        for( int i =0 ; i<24; i++){
            if(currentTired+A <= M){
                totalWork +=B;
                currentTired +=A;
            }else{
                currentTired -=C;
                if(currentTired <0) currentTired=0;
            }
        }
        System.out.println(totalWork);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

}


