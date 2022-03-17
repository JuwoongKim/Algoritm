package CodingTest.Concept.Simulation;

import java.util.*;
import java.io.*;


class Point{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ17144 {

    public static int [] dr ={0,-1,0,1};
    public static int [] dc ={-1,0,1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 배열 초기화
        int [][] arr = new int [R][C];
        for (int i = 0; i <R ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <C ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기청전기 위치 확인
        Point up = null;
        Point down = null;
        for (int i = 0; i <R ; i++) {
            if(arr[i][0]==-1){
                up = new Point(i,0);
                down = new Point(i+1,0);
                break;
            }
        }

        // 시뮬레이션 시작
        for (int t = 0; t <T ; t++) {

            // 미세먼지 증식
            int [][] tempArr = new int [R][C];

            for (int i = 0; i <R ; i++) {
                for (int j = 0; j <C ; j++) {

                    if(arr[i][j] == -1){
                        tempArr[i][j] =-1;
                        continue;
                    }

                    if (arr[i][j] != 0 ){

                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int tr = i + dr[k];
                            int tc = j + dc[k];
                            if (tr >= 0 && tr < R && tc >= 0 && tc < C && arr[tr][tc] != -1) {
                                tempArr[tr][tc] += arr[i][j]/5;
                                cnt++;
                            }
                        }
                        tempArr[i][j] += (arr[i][j]- (arr[i][j]/5)*cnt);
                    }
                }
            }
            arr =tempArr;

            // 공기청정기 바람


            // 위
            for(int i = up.x-1 ; i>=1 ; i--){
                arr[i][0] = arr[i-1][0];
            }
            for(int j = 0; j<C-1 ; j++){
                arr[0][j] = arr[0][j+1];
            }
            for(int i = 0 ; i<up.x ; i++){
                arr[i][C-1] = arr[i+1][C-1];
            }
            for(int j = C-1; j>=1; j--){
                if(j==1) {
                    arr[up.x][j] =0;
                    continue;
                }
                arr[up.x][j] = arr[up.x][j-1];
            }

            //아래
            for(int i = down.x+1; i<R-1; i++){
                arr[i][0] = arr[i+1][0];
            }

            for(int j=0; j<C-1; j ++){
                arr[R-1][j] = arr[R-1][j+1];
            }

            for(int i =R-1 ; i>down.x ; i--){
                arr[i][C-1] = arr[i-1][C-1];
            }

            for(int j =C-1; j>=1 ; j--){
                if(j==1) {
                    arr[down.x][j] = 0;
                    continue;
                }
                arr[down.x][j] = arr[down.x][j-1];
            }

        }

        int answer = 0;

        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                if(arr[i][j]==-1) continue;
                answer += arr[i][j];
            }
        }

        System.out.println(answer);

    }
}
