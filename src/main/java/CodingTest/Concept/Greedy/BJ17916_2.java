package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ17916_2 {

    public static void main(String [] arg) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt =0;

        while(N>=-1){
            if(N%5==0){
                cnt += N/5;
                N=0;
                break;
            }else{
                N-=2;
                cnt ++;
            }
        }
        if(N!= 0)System.out.println(-1);
        else System.out.println(cnt);

    }
}
