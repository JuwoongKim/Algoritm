package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;

public class BJ14719 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        boolean [][] blockMap = new boolean [row][col];
        st= new StringTokenizer(br.readLine());

        for (int c = 0; c <col ; c++) {
            int h = Integer.parseInt(st.nextToken());
            int max = row-1;
            for (int i = 0; i <h ; i++) {
                blockMap[max-i][c] = true;
            }
        }

        int answer = 0;
        int max = row-1;
        for (int r = max; r >=0 ; r--) {

            int temp = 0;
            List<Integer> blocks = new ArrayList<>();

            for (int c = 0; c <col ; c++)
                if(blockMap[r][c]) blocks.add(c);

            if(blocks.size()>=2){
                for(int i=0; i<blocks.size()-1; i++)
                    temp += blocks.get(i+1)-blocks.get(i)-1;
            }
            answer += temp;
        }

        System.out.println(answer);

    }
}
