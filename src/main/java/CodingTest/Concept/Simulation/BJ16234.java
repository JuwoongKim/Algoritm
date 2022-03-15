package CodingTest.Concept.Simulation;

import java.util.*;
import java.io.*;


class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class UnionInfo {

    List<Point> pointList;
    int sum;
    int num;

    public UnionInfo(List<Point> pointList, int sum, int num) {
        this.pointList =pointList;
        this.sum = sum;
        this.num = num;
    }
}

public class BJ16234 {

    // 상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N;
    public static int L;
    public static int R;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = 0;
        boolean isChange = false;

        while (true) {

            // 체크정보 초기화
            List<UnionInfo> unionInfoList = new ArrayList<>();
            isChange = false;
            for (int i = 0; i < N; i++) {
                Arrays.fill(check[i], false);
            }

            // 연합국찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j]) {
                        UnionInfo temp = BFS(i, j, arr, check);
                        if(temp.pointList.size()>1){
                            unionInfoList.add(temp);
                            isChange = true;
                        }
                    }
                }
            }

            // 변화가 있엇니?? 없으면 끝
            if (!isChange) break;

            //있으면 인구이동
            for(UnionInfo info : unionInfoList){
                int value = info.sum/ info.num;
                for(Point point : info.pointList){
                    arr[point.x][point.y] = value;
                }
            }
            //  횟수 추가
            answer++;

        }


        System.out.println(answer);
    }

    public static UnionInfo BFS(int x, int y, int[][] arr, boolean[][] check) {

        List<Point> pointList = new ArrayList<>();
        int sum = 0;
        int num = 0;

        Queue<Point> q = new LinkedList<>();
        check[x][y] = true;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {

            Point temp = q.poll();
            pointList.add(temp);
            sum += arr[temp.x][temp.y];
            num++;

            for (int i = 0; i < 4; i++) {
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];

                if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    if (check[tx][ty]) continue;
                    int diff = Math.abs(arr[temp.x][temp.y] - arr[tx][ty]);
                    if (diff >= L && diff <= R) {
                        check[tx][ty] = true;
                        q.offer(new Point(tx, ty));
                    }
                }
            }
        }

        return  new UnionInfo(pointList, sum, num);
    }

}






////

/*
    public static void BFS(int x, int y, int [][] arr, boolean [][] check){

        int sum=0;
        int num=0;
        Queue<Point> store = new LinkedList<>();
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while(!q.isEmpty()){
            Point temp = q.poll();
            store.offer(temp);
            check[temp.x][temp.y] = false;
            sum += arr[temp.x][temp.y];
            num ++;

            for (int i = 0; i <4 ; i++) {
                int tx = temp.x+dx[i];
                int ty = temp.y+dy[i];
                if(tx>=0 && tx< arr.length && ty>=0 && ty< arr.length){
                    if(check[tx][ty]){
                        check[tx][ty] = false;
                        q.offer(new Point(tx,ty));
                    }
                }
            }
        }

        int divide = sum/num;

        while(!store.isEmpty()){
            Point temp = store.poll();
            arr[temp.x][temp.y]=divide;
        }
    }
*/










