package CodingTest.Concept.Greedy;

import java.util.*;
import java.io.*;

public class BJ1343 {

    public static void main( String [] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        boolean isOdd = false;
        while (true) {

            char c = str.charAt(0);
            char reverseC;
            if (isX(c)) reverseC = '.';
            else reverseC = 'X';
            int dividePoint = str.indexOf(reverseC);
            if(dividePoint ==-1) {
                // 마지막일때
                if (isX(c)) {
                    // 덮어 씌우기
                    int length = str.length();
                    if (length % 2 != 0) {
                        isOdd = true;
                        break;
                    }
                    while (length != 0) {
                        if (length - 4 >= 0) {
                            answer += "AAAA";
                            length -= 4;
                            continue;
                        }
                        if (length - 2 <= 0) {
                            answer += "BB";
                            length -= 2;
                        }
                    }
                } else {
                    answer += str;
                }
                break;
            }else {
                String temp = str.substring(0, dividePoint);
                if (isX(c)) {
                    // 덮어 씌우기
                    int length = temp.length();
                    if (length % 2 != 0) {
                        isOdd = true;
                        break;
                    }
                    while (length != 0) {
                        if (length - 4 >= 0) {
                            answer += "AAAA";
                            length -= 4;
                            continue;
                        }
                        if (length - 2 <= 0) {
                            answer += "BB";
                            length -= 2;
                        }
                    }
                } else {
                    answer += temp;
                }
                str = str.substring(dividePoint);
            }
        }
        if(isOdd) System.out.println(-1);
        else System.out.println(answer);
    }

    public static  boolean isX(char c ){
        return c=='X';
    }

}
