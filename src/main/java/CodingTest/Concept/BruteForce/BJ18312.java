package CodingTest.Concept.BruteForce;

import java.util.*;
import java.io.*;

public class BJ18312 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int  K = Integer.parseInt(st.nextToken());

        int cnt =0;
        for(int h=0; h<=N; h++){
            for (int m = 0; m <60 ; m++) {
                for (int s = 0; s <60 ; s++) {
                    if(isSatisfied(h,m,s,K)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean isSatisfied( int h, int m , int s, int K){

        boolean result = false;
        int [] arr = new int [6];

        for(int i=1; i>=0; i--){
            arr[i]= h%10;
            h= h/10;
        }

        for(int i=3; i>=2; i--){
            arr[i]= m%10;
            m= m/10;
        }

        for(int i=5; i>=4; i--){
            arr[i]= s%10;
            s= s/10;
        }

        for(int ele : arr){
            if(ele ==K){
                result =true;
                break;
            }
        }
        return result;
    }



}
