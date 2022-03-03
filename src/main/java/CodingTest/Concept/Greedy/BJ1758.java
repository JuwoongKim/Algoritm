package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ1758 {

    public static void main(String [] arg) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine());
        Integer [] arr = new Integer [100000];
        Arrays.fill(arr, Integer.MIN_VALUE);

        for(int i =0; i <N ; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());

        long answer = 0;
        for(int i =0; i <N; i++) {

            int temp =arr[i] - i;
            if(temp<0) temp =0;
            answer += temp;
        }
        System.out.println(answer);
    }
}


