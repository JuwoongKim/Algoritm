package CodingTest.Concept.BruteForce;

import  java.util.*;
import  java.io.*;

public class BJ2798 {

    public static void main(String[] args) throws  IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int numOfCard = Integer.parseInt(st.nextToken());
        int bound = Integer.parseInt(st.nextToken());
        int [] arr = new int [numOfCard];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i <numOfCard; i++) arr[i] =  Integer.parseInt(st.nextToken());


        int max = Integer.MIN_VALUE;
        for(int i =0; i<numOfCard-2; i++){
            for (int j = i+1; j <numOfCard-1 ; j++) {
                for (int k = j+1; k <numOfCard ; k++) {
                    int temp = arr[i]+arr[j]+arr[k];
                    if(temp>bound) continue;
                    else{
                        if(temp>max)
                            max =temp;
                    }
                }
            }
        }

        System.out.println(max);


    }
}
