package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ11399 {

    public static void main(String [] arg) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N =  Integer.parseInt( br.readLine());
        int [] arr = new int [1000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i< N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        long answer = 0 ;
        long sum =0;
        for(int i =0; i<N; i++){
            answer += sum +arr[i];
            sum += arr[i];
        }

        System.out.println(answer);
    }
}


