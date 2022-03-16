package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ20115 {

    public static void main (String [] arg )throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int  [] arr = new int  [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        double answer = 0;

        for(int i =0; i<N-1; i++){
            answer += ((double)arr[i]/2);
        }
        answer += (double)arr[N-1];
        System.out.println(answer);

    }
}
