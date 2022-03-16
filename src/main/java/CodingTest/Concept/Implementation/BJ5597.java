package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

public class BJ5597 {

    public static void main(String [] arg) throws IOException{

        BJ5597 T = new BJ5597();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr = new int [31];

        for(int i =0; i<28; i++){
            int input = Integer.parseInt(br.readLine());
            arr[input] = input;
        }

        for(int i =0 ; i < arr.length ; i++)
        {
            if(i==0) continue;
            if(arr[i]==0) System.out.println(i);
        }

    }

}
