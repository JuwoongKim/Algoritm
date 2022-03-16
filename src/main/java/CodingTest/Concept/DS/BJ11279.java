package CodingTest.Concept.DS;

import java.util.*;
import java.io.*;

public class BJ11279 {

    public static void main(String[] args)  throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i <N ; i++) {
            temp = Integer.parseInt(br.readLine());

            if(temp==0){

                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }

            }else{
                pq.offer(temp);
            }
        }
    }

}
