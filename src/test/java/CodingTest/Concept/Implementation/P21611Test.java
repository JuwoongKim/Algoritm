package CodingTest.Concept.Implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class P21611Test {


    @Test
    public void arrayListIterateTest(){

        List <Integer> list = new ArrayList<>();
        list.add(-1);
        for(int i=0; i<3; i++) list.add(i);
        for(int i=0; i<5; i++) list.add(10);
        for(int i=0; i<3; i++) list.add(i);

/*  일반식 사용
        int prev = Integer.MIN_VALUE;
        int prevCnt=0;
        int fixSize = list.size();
        for(int i =0; i<list.size() ; i++){

            if(i ==fixSize-1){
                continue;
            }else{
                int current= list.get(i);
                if(current!=prev) {
                    if(prevCnt>=4){
                        while(prevCnt>0){
                            list.remove(--i);
                            prevCnt--;
                        }
                    }
                    prevCnt =0;
                }
                prevCnt ++;
                prev = current;

            }


        }
*/
        for(Integer ele : list){
            System.out.print( ele + " ");
        }

    }


    @Test
    public void simpleTest(){

        String str = "taaaaaaad";
        int idx = str.indexOf('b');
        System.out.println(idx);

        //내가 궁금한것
        str = str.substring(8);
        System.out.println(str);
    }

    @Test
    public void justTest(){
        String a = "abc";
        System.out.println(1 + 2+ a);
        System.out.println(1 + a+ 2);
        System.out.println(1 +2 +a+ 1+ 2);
        System.out.println(a+ 2+1);

        System.out.println(1 + 2);
        System.out.println('a' + 'b');
        System.out.println("1" + "2");
    }

    @Test
    public void ttt(){
        int a =  7;
        int b =  3;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a&b));

    }

}











