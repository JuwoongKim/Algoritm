package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

class JH{
    private int money;
    private int numOfStock;
    private int totalValue;

    public JH(int money ){
        this.money = money;
        this.numOfStock = 0;
        this.totalValue =0;  //초기화를 필드값에 하는것과 이렇게 하는게 무슨 차이가 있을까??
    }

    public void doingPerDay( int currentPrice){
        while(canBuy(currentPrice)){
            buyStock(currentPrice);
        }
    }

    private boolean canBuy(int currentPrice){
        return money-currentPrice>=0;
    }

    private void buyStock(int currentPrice){
        money -=currentPrice;
        numOfStock++;
    }

    public int  getTotalValue(int currentPrice){
        totalValue = money + (numOfStock*currentPrice);
        return totalValue;
    }

}


class SM{
    private int money;
    private int numOfStock;
    private int totalValue;
    private List<Integer> stockHistory;
    private int prevValue;

    public SM(int money ){
        this.money = money;
        this.numOfStock = 0;
        this.totalValue =0;  //초기화를 필드값에 하는것과 이렇게 하는게 무슨 차이가 있을까??
        stockHistory = new ArrayList<>();
        stockHistory.add(0);
        prevValue= 0;
    }

    public void doingPerDay( int currentPrice){
        stockHistory.add(currentPrice);
        if(stockHistory.size()<4) return;
        else{
            if(isDownStream()) {
                while(canBuy(currentPrice)){
                    buyStock(currentPrice);
                }
                return;
            }
            if(isUpStream()){
                sellStock(currentPrice);
                return;
            }
        }
    }

    public boolean isUpStream(){
        int tempCnt =0;
        for(int i = stockHistory.size()-1; i>stockHistory.size()-4; i--){
            if(i==1)continue;
            if(stockHistory.get(i)>stockHistory.get(i-1)) tempCnt ++;
        }
        return tempCnt>=3;
    }

    private boolean canBuy(int currentPrice){
        return money-currentPrice>=0;
    }

    private void buyStock(int currentPrice){
        money -=currentPrice;
        numOfStock++;
    }

    public boolean isDownStream(){
        int tempCnt =0;
        for(int i = stockHistory.size()-1; i>stockHistory.size()-4; i--){
            if(i==1) continue;
            if(stockHistory.get(i)<stockHistory.get(i-1)) tempCnt ++;
        }
        return tempCnt>=3;
    }

    public void sellStock(int currentPrice){
        money += (currentPrice*numOfStock);
        numOfStock=0;
    }


    public int  getTotalValue(int currentPrice){
        totalValue = money + (numOfStock*currentPrice);
        return totalValue;
    }
}


public class BJ20546 {

    public static void main (String [] arg) throws IOException{

        BJ20546 T = new BJ20546();
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int seedMoney = Integer.parseInt(br.readLine());
        int [] priceArr = new int [14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<14; i++) priceArr[i] =Integer.parseInt(st.nextToken());
        T.solution(seedMoney, priceArr);
    }

    public void solution(int seedMoney, int [] priceArr){

        JH jh = new JH(seedMoney);
        SM sm = new SM(seedMoney);
        int jhValue=0;
        int smValue=0;

        for( int i =0 ; i <priceArr.length ; i ++){
            jh.doingPerDay(priceArr[i]);
            sm.doingPerDay(priceArr[i]);
            if(i==priceArr.length-1){
                jhValue = jh.getTotalValue(priceArr[i]);
                smValue = sm.getTotalValue(priceArr[i]);
            }
        }

        if(jhValue>smValue) System.out.println("BNP");
        else if (jhValue<smValue) System.out.println("TIMING");
        else  System.out.println("SAMESAME");

    }
}
