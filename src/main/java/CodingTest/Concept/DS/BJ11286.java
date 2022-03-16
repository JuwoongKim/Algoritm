package CodingTest.Concept.DS;

import java.util.*;
import java.io.*;

public class BJ11286 {

    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(Math.abs(o1)==Math.abs(o2)){
                    return  o1-o2;
                }else{
                    return  Math.abs(o1)-Math.abs(o2);
                }
            }
        }) ;


        int temp=0;
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
