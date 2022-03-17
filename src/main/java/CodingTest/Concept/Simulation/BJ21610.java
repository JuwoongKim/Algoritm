package CodingTest.Concept.Simulation;

import java.util.*;
import java.io.*;


class Point{
    int x;
    int y;
    public  Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BJ21610 {

    public static int [] dr = {0,-1,-1,-1,0,1,1,1};
    public static int [] dc = {-1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] arr = new int [N][N];
        boolean [][] check = new boolean[N][N];
        List<Point> list = new ArrayList<>();

        for (int i = 0; i <N ; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N-2; i <N ; i++) {
            for (int j = 0; j <2 ; j++) {
                list.add(new Point(i,j));
            }
        }

        int d =0 ;
        int s =0;
        // 명령시행
        for (int i = 0; i <M ; i++) {
            st= new StringTokenizer(br.readLine());
            d =Integer.parseInt(st.nextToken())-1;
            s =Integer.parseInt(st.nextToken());


            // 위치만큼 이동후 체크 + 물 ++;
            for(Point ele : list){
                int tr = ele.x+dr[d]*s;
                int tc = ele.y+dc[d]*s;

                if(tr>N-1) tr %=N;
                if(tc>N-1) tc %=N;
                if(tr < 0) tr = (N+(tr%N))%N;
                if(tc < 0) tc = (N+(tc%N))%N;
                ele.x =tr;
                ele.y =tc;
            }

            for (int j = 0; j <N ; j++) {
                Arrays.fill(check[j],false);
            }

            for(Point ele : list){
                check[ele.x][ele.y] = true;
                arr[ele.x][ele.y] +=1;
            }


            // 대각선 구름 더하기 1 3 5 7
            int [] cross = {1,3,5,7};
            for(Point ele : list){
                for(int idx : cross){
                    int tr = ele.x + dr[idx];
                    int tc = ele.y + dc[idx];
                    if(tr>=0 && tr<N && tc>=0 &&tc<N){
                        if(arr[tr][tc]>0)
                            arr[ele.x][ele.y] ++;
                    }
                }
            }

            //새로운 구름 형성하기
            list.clear();
            for (int j = 0; j <N ; j++) {
                for (int k = 0; k <N ; k++) {

                    if(check[j][k]){
                        check[j][k] = false;
                        continue;
                    }

                    if(arr[j][k] >=2){
                        arr[j][k] -=2;
                        check[j][k] = true;
                        list.add(new Point(j,k));
                    }
                }
            }
        }


        int answer =0;
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);


    }
}
