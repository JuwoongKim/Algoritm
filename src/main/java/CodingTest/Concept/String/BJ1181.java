package CodingTest.Concept.String;

import java.util.*;
import java.io.*;

public class BJ1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        String ss= "";
        for(int i =0; i<n; i++){

            ss = br.readLine();
            if(list.contains(ss)) continue;

            list.add(ss);
        }

        Comparator<String> comparator  = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()){

                    int result=0;
                    for(int i =0 ; i<o1.length();i++){

                        if(o1.charAt(i)==o2.charAt(i))
                            continue;

                        result =o1.charAt(i)-o2.charAt(i);
                        break;
                    }

                    return result;

                }else{
                    return o1.length()-o2.length();
                }
            }
        };

        Collections.sort(list, comparator);

        StringBuilder sb = new StringBuilder();

        for(String str : list){
            sb.append(str +'\n');
        }

        System.out.println(sb.toString());

    }

}
