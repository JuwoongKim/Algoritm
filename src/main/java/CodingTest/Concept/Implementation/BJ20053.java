package CodingTest.Concept.Implementation;
import java.io.*;
import java.util.*;

public class BJ20053 {

    public static void main(String [] arg) throws IOException{

        BJ20053 T = new BJ20053();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(bufferedReader.readLine());

        for(int i=0 ; i<times; i++){
            int size = Integer.parseInt(bufferedReader.readLine());
            int [] arr = new int[size];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            for(int j =0; j <size; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            T.solution(size,arr);
        }
    }

    public void solution(int size, int [] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        String result = min + " " + max;
        System.out.println(result);
    }

}
