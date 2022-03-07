package CodingTest.Concept.DivideAndConquer;

import java.util.*;
import java.io.*;

public class BJ17829 {
    public static  int answer;
    public static void main(String[] args) throws IOException{

        BJ17829 T = new BJ17829();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int [N][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.recursive(N,arr);
        System.out.println(answer);
    }


    public void recursive(int N, int [][] arr){

        if(N==1){
            answer = arr[0][0];
            return;
        }

        int [][] temp = new int[N/2][N/2];

        for(int i=0; i<N; i+=2){
            for (int j = 0; j <N ; j+=2) {
                int secondMax = getsecondMax(i, j, arr);
                temp[i/2][j/2] = secondMax;
            }
        }
        recursive(N/2, temp);
    }

    public int getsecondMax(int x, int y, int [][] arr){
        List<Integer> list = new ArrayList<>();
        for (int i = x; i <x+2 ; i++) {
            for (int j = y; j <y+2 ; j++) {
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
        return  list.get(2);
    }


}
