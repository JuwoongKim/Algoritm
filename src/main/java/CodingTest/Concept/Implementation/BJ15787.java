package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

public class BJ15787 {

    public static void main(String[] args) throws IOException {

        int full = (int)Math.pow(2,20)-1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] list = new int[N];

        int mode=0;
        int i = 0;
        int x=0;
        int temp=0;
        int mask=0;
        for (int j = 0; j <M ; j++) {
            st = new StringTokenizer(br.readLine());
            mode = Integer.parseInt(st.nextToken());
            i = Integer.parseInt(st.nextToken());
            if(mode == 1 || mode ==2) x=Integer.parseInt(st.nextToken());
            temp=0;
            mask=0;

            switch(mode){
                case 1 :  temp = list[i-1];
                          mask = (int)Math.pow(2,x-1);
                          temp = temp|mask;
                          temp &=full;
                          list[i-1] =temp;
                          break;

                case 2 : temp = list[i-1];
                         mask = (int)Math.pow(2,x-1);
                         mask ^= full;
                         temp &=mask;
                         temp &=full;
                         list[i-1] = temp;
                         break;

                case 3 : temp = list[i-1];
                         temp <<=1;
                         temp &=full;
                         list[i-1] = temp;
                         break;

                case 4 : temp = list[i-1];
                         temp>>>=1;
                         temp &=full;
                         list[i-1] =temp;
                         break;
            }
        }
        int answer =1;
        boolean isSame = false;
        List<Integer> fiters = new ArrayList<>();
        fiters.add(list[0]);

        for (int j = 1; j <N ; j++) {
            isSame = false;
            for(int filter : fiters){
                if(filter == list[j]){
                    isSame =true;
                    break;
                }
            }
            if(!isSame){
                answer ++;
                fiters.add(list[j]);
            }
        }
        System.out.println(answer);
    }
}
