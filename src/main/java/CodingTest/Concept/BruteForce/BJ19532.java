package CodingTest.Concept.BruteForce;

import  java.util.*;
import java.io.*;

public class BJ19532 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lower = -999;
        int upper = 999;

        int [] arr  = new int [6];
        for (int i = 0; i <6 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x = lower ; x<=upper; x++){
            for(int y =lower ; y<=upper; y++){

                int first = arr[0]*x + arr[1]*y;
                int second = arr[3]*x + arr[4]*y;
                if(first == arr[2] && second == arr[5])
                {
                    System.out.println(x + " "+ y);
                    break;
                }
            }
        }

    }

}
