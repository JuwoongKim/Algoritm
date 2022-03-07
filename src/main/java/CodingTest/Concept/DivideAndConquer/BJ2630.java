package CodingTest.Concept.DivideAndConquer;
import java.util.*;
import java.io.*;

public class BJ2630 {

    public static int blueCnt;
    public static int whiteCnt;

    public static void main(String[] args) throws IOException{

        BJ2630 T = new  BJ2630 ();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int  [][] arr = new int [N][N];

        StringTokenizer st;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.recursive(0,0,N-1,N-1, arr);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }


    public void recursive(int x1, int y1, int x2, int y2, int [][] arr){

        if(isSatisfied(x1, y1, x2, y2, arr) || x1==x2){
            if (arr[x1][y1] == 0) whiteCnt ++;
            else blueCnt ++;
            return;
        }

        int mx = (x1+x2)/2+1;
        int my = (y1+y2)/2+1;

        recursive(x1, y1, mx-1, my-1, arr );
        recursive(mx, y1, x2, my-1, arr );
        recursive(x1, my, mx-1, y2, arr );
        recursive(mx, my, x2, y2, arr );


    }


    public boolean isSatisfied (int x1, int y1, int x2, int y2, int [][]arr){
        boolean answer= true;
        int first = arr[x1][y1];
        for(int i=x1; i<=x2 ; i++){
            for (int j = y1; j <=y2 ; j++) {
                if(first != arr[i][j]){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

}
