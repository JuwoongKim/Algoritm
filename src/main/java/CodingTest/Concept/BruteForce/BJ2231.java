package CodingTest.Concept.BruteForce;

import java.util.*;
import java.io.*;

public class BJ2231 {

    public static void main(String[] args) throws  IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();
        int upperBound = Integer.parseInt(str);
        int lowerBound = upperBound -(size*9);

        int answer = 0 ;
        for(int i = lowerBound ; i<=upperBound ; i++){
            List<Integer> list = makeNumber(i);
            int temp = i + list.stream().mapToInt(j->j).sum();
            if(temp==upperBound) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }

    public static List<Integer> makeNumber(int n){

        List<Integer> result = new ArrayList<>();
        while(n!=0){
            result.add(n%10);
            n= n/10;
        }
        return result;
    }

}
