package CodingTest.Concept.Implementation;

import java.util.*;
import java.io.*;



class Sche implements Comparable{

    int first;
    int last;
    int period;
    public Sche (int first, int last){
        this.first =first;
        this.last =last;
        period = last-first + 1;
    }

    @Override
    public int compareTo(Object o) {
        Sche w =(Sche) o;
        if(first == w.first){
            return w.period- period;
        }else{
            return first -w.first;
        }
    }
}

public class BJ20207 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        List<Sche> list = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            list.add(new Sche(first, last));
        }

        Collections.sort(list);

        int first = Integer.MIN_VALUE;
        int answer =0;
        List<Integer> lasts = new ArrayList<>();

        for (int i = 0; i <N ; i++) {
            if(i==0){
                first = list.get(i).first;
                lasts.add(list.get(i).last);
            }else{
                int tFirst = list.get(i).first;
                int tLast = list.get(i).last;

                if(tFirst> Collections.max(lasts)){

                    if(tFirst-Collections.max(lasts)==1 ) {
                        int idx = lasts.indexOf(Collections.max(lasts));
                        lasts.set(idx, tLast);
                        continue;
                    }

                    int wide = Collections.max(lasts)-first +1;
                    int height = lasts.size();
                    answer += wide*height;
                    lasts.clear();
                    first=tFirst;
                    lasts.add(tLast);

                }else{
                    boolean isChange = false;
                    for(int k =0; k <lasts.size() ; k++){
                        if(lasts.get(k)<tFirst){
                            lasts.set(k,tLast);
                            isChange =true;
                            break;
                        }
                    }
                    if(!isChange) lasts.add(tLast);
                }
            }



        }

        answer += (Collections.max(lasts)-first+1)*lasts.size();

        System.out.println(answer);


    }
}
