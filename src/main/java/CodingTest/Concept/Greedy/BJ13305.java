package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ13305 {

    public static void main(String [] arg)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfNode = Integer.parseInt(br.readLine());

        int [] edges = new int [numOfNode-1];
        int [] nodes = new int [numOfNode];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<numOfNode-1; i ++) edges[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<numOfNode; i ++) nodes[i] = Integer.parseInt(st.nextToken());


        long answer =0;
        int boundIdx=0;
        for(int i=0 ; i<numOfNode-1; i++){
            if(i==0){
                answer += edges[i]*nodes[i];
            }else{
                if(nodes[i]<=nodes[boundIdx]){
                    // 새로온 노드의 값이  더작다면
                    boundIdx = i;
                    answer += nodes[i]*edges[i];
                }else{
                    answer += nodes[boundIdx]*edges[i];
                }
            }
        }
        System.out.println(answer);
    }

}
