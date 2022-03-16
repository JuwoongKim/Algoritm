package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;



public class BJ21918 {

    public static void main(String [] arg)throws IOException, Exception{

        BJ21918 T = new BJ21918();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int numOfBulb =Integer.parseInt(st.nextToken());
        int numOfCommand = Integer.parseInt(st.nextToken());

        int [] bulbArr = new int [numOfBulb];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<bulbArr.length ; i++) bulbArr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i <numOfCommand; i++){
            int [] infoArr = new int[3];
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) infoArr[j] = Integer.parseInt(st.nextToken());
            T.solution(infoArr, bulbArr);
        }
        for( int bulb : bulbArr) System.out.print(bulb +" ");
    }

    public void solution(int [] infoArr, int [] buibArr)throws Exception{

        switch(infoArr[0]){
            case 1 :    changeIndexOfBulb(infoArr[1],infoArr[2], buibArr);
                        break;
            case 2 :    changeRangeOfBulb(infoArr[1],infoArr[2], buibArr);
                        break;
            case 3:     turnOffRangeOfBulb(infoArr[1],infoArr[2], buibArr);
                        break;
            case 4 :    turnOnRangeOfBulb(infoArr[1],infoArr[2], buibArr);
                        break;
            default: throw new Exception();
        }

    }

    public void changeIndexOfBulb(int index, int result, int [] bulbArr){
        bulbArr[index-1] = result;
    }

    public void changeRangeOfBulb( int startIdx, int endIdx,int[]  bulbArr){
        for(int i = startIdx-1 ; i <=endIdx-1 ; i++){
            if(bulbArr[i]==0) bulbArr[i]=1;
            else bulbArr[i]=0;
        }
    }

    public void turnOffRangeOfBulb(int startIdx, int endIdx, int [] bulbArr){
        for(int i = startIdx-1 ; i <=endIdx-1 ; i++) bulbArr[i]=0;
    }

    public void turnOnRangeOfBulb(int startIdx, int endIdx, int [] bulbArr){
        for(int i = startIdx-1 ; i <=endIdx-1 ; i++) bulbArr[i]=1;
    }


}
