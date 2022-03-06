package CodingTest.Concept.Implementation;

import java.util.*;

public class BJ1212 {


    public static void main(String [] arg){

        BJ1212 T = new BJ1212();
        Scanner scanner = new Scanner(System.in);

        String inputOctal = scanner.nextLine();
        String  answer = T.solution(inputOctal);
        System.out.println(answer);
    }

    public String solution(String inputOctal){

        StringBuilder binary = new StringBuilder();

        for(int i =0; i <inputOctal.length(); i++){
            String temp = Integer.toBinaryString(inputOctal.charAt(i)-'0');
            if(temp.length()==2&& i!=0) temp = "0"+temp;
            else if(temp.length()==1 && i!=0) temp = "00" +temp;
            binary.append(temp);
        }

        return  binary.toString();
    }
}
