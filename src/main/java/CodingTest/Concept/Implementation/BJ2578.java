package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

class Location2{

    private int row;
    private int col;

    public Location2(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}


public class BJ2578 {

    public static boolean [][] bingoArr =new boolean [5][5];




    public static void main(String [] arg)throws IOException{
        BJ2578 T= new BJ2578();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int bingoCnt=0;
        int answerIdx=0;
        Map<Integer,Location2> number2Location = new HashMap<>();

        int [][] numberArr = new int [5][5];
        for(int i =0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j <5; j++){
                int tempValue = Integer.parseInt(st.nextToken());
                numberArr[i][j] = tempValue;
                number2Location.put(tempValue, new Location2(i,j));
            }
        }

        for(int i =0; i<5;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                answerIdx ++;
                int tempNum = Integer.parseInt(st.nextToken());
                Location2 temp = number2Location.get(tempNum);
                bingoArr[temp.getRow()][temp.getCol()] = true;
                if(answerIdx<=11){
                    continue;
                }else{
                    bingoCnt=T.checkBingoArr(bingoArr);
                }
                if(bingoCnt>=3)break;
            }
            if(bingoCnt>=3) break;
        }
        System.out.println(answerIdx);

    }



    public int checkBingoArr(boolean[][] bingoArr){

        int totalCnt=0;
        for(int i = 0; i<5; i++){
            int rowCnt =0;
            int colCnt = 0;
            for(int j=0; j<5; j++){
                if( bingoArr[i][j]==true) rowCnt ++;
                if(bingoArr[j][i]==true) colCnt ++;
            }
            if(rowCnt==5) totalCnt++;
            if(colCnt==5) totalCnt ++;
        }

        int downCnt=0;
        int upCnt =0;
        for(int i=0; i<5; i++){
            if(bingoArr[i][i]==true) downCnt++;
            if(bingoArr[i][4-i]==true) upCnt++;
        }
        if(downCnt ==5) totalCnt ++;
        if(upCnt ==5) totalCnt ++;
        return totalCnt;
    }

}
