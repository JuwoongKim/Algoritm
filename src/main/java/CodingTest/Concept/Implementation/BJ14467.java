package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

public class BJ14467 {

    public static void main(String [] arg)throws IOException{

        BJ14467 T = new BJ14467();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int observeCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        int answer =0 ;
        for(int i =0; i <observeCnt ; i++){
            st = new StringTokenizer(bf.readLine());
            int cowIdx = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if(T.isChange(map, cowIdx,location)) answer ++;
            map.put(cowIdx, location);
        }
        System.out.println(answer);
    }


    public boolean isChange(Map<Integer, Integer> map, int cowIdx, int location){
        boolean changed = false;

        if(map.containsKey(cowIdx)){
            if(map.get(cowIdx)!=location)
                changed =true;
        }
        return changed;
    }

}
