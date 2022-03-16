package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ20300 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long [N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i]=Long.parseLong(st.nextToken());

        }
        Arrays.sort(arr);
        long max = Integer.MIN_VALUE;
        long temp=0;
        int lt =0;
        int rt=N-1;
        if( N%2!=0){
            max = arr[N-1];
            rt = N-2;
        }

        while(lt<rt){

            temp = arr[lt] + arr[rt];
            if(max<temp) max = temp;
            lt ++;
            rt --;
        }

        System.out.println(max);

    }

}
