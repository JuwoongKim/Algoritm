package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ11508 {

    public static void main (String [] arg) throws IOException{

        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        Integer [] arr = new Integer [ 100000 ] ;
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(arr, Integer.MIN_VALUE);
        for(int i =0 ; i <N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        long answer = 0;
        for(int i =0; i<N ; i++){
            if((i+1)%3==0)
                continue;

            answer += arr[i];
        }

        System.out.println(answer);
    }

}


