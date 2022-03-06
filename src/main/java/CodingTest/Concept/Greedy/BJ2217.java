package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ2217 {

    public static  void main(String [] arg) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int [] arr = new int [ 100000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i =0 ; i<num; i ++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = Integer.MIN_VALUE;
        int fixNum = num;
        for(int i=0; i<fixNum; i++){
            int temp = arr[i]*num;
            if(temp>answer)
                answer =temp;

            num --;
        }
        System.out.println(answer);
    }

}
