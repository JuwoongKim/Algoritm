package CodingTest.Concept.Math;

import java.util.*;
import java.io.*;

public class BJ5618 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] strs = br.readLine().split(" ");
        int [] nums = new int[N];
        for (int i = 0; i <N ; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(nums);
        int gcd =nums[0];
        for (int i = 1; i <N ; i++) {
            gcd = GCD(gcd,nums[i]);
        }

        int cnt = 0;
        for (int i = 1; i <=gcd ; i++) {
            cnt = 0;
            for (int j = 0; j <N ; j++) {
                if(nums[j]%i==0) cnt++;
            }
            if(cnt==N) System.out.println(i);
        }

    }


    public static int GCD(int a, int b){

        int result =0;
        int mod = 0;
        while(true){

            b = b%a;
            if(b==0){
                result = a;
                break;
            }

            a = a%b;
            if(a==0){
                result =b;
                break;
            }
        }
        return result;
    }


}
