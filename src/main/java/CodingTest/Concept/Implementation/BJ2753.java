package CodingTest.Concept.Implementation;

import java.util.*;

public class BJ2753 {

    public static void main( String [] arg){

        BJ2753 T = new BJ2753();
        Scanner scanner = new Scanner(System.in);
        int inputYear = scanner.nextInt();
        T.solution(inputYear);
    }

    public void solution(int inputYear){

        int answer = 0;
        if( (inputYear%4==0)&&(inputYear%100!=0)||(inputYear%400==0)){
            answer =1;
        }
        System.out.println(answer);
    }

}
