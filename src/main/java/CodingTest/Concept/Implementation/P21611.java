package CodingTest.Concept.Implementation;

import java.util.*;

class Location{

    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public int hashCode() {
        return row*(-111) + (col*3333);
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Location){
            Location location = (Location) obj;
            if( this.row ==location.getRow() || this.col ==location.getCol())  return true;
            else return false;
        }else{
            return false;
        }

    }
}

class TrialInfo{

    private int direction;
    private int length;

    public TrialInfo(int direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public int getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }
}


public class P21611 {

    public static int [] moveX = {-100,0,0,-1,1};
    public static int [] moveY = {-100,-1,1,0,0};
    public static int [] directionOrder = {3,2,4,1};
    public static int [] beadExploadCnt ={0,0,0,0} ;

    public static void main( String [] arg){

        // 변수에 입력값 할당
        P21611 T = new P21611();
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int trialCnt = scanner.nextInt();

        int [][] arr = new int [size][size];
        for(int row =0; row< size; row++){
            for(int col =0; col<size; col ++)
                arr[row][col] = scanner.nextInt();
        }

        List<TrialInfo> trialInfoList = new ArrayList<>();
        for(int i =0 ; i<trialCnt; i++) trialInfoList.add(new TrialInfo(scanner.nextInt(), scanner.nextInt()));

        // solution 함수에 대입
        T.solution(size, arr, trialInfoList);
    }

    public void solution(int size, int [][] arr, List<TrialInfo> trialInfoList )
    {
        // 순회 순서에 해당하는 구슬의 정보를 담는 리스트
        List<Integer> beadList = new ArrayList<>();
        beadList.add(-1); // 인덱스를 1부터 시작하기 위한 쓰레기 값

        // 순회순서에 해당하는 좌표정보를 구하는 해시 맵.
        Map <Location, Integer> locationIdxMap = new HashMap<>();

        // 좌표정보 arr를 순회하면서 위의 두 리스트에 정보를 담는다.
        int startRow = (size-1)/2, startCol = (size-1)/2;
        int currentRow = startRow, currentCol = startCol;

        int idxForMap =0;
        int directionIdx=0;
        int unitLength=1;

        while( true ) {
            for (int unitCnt = 0; unitCnt < 2; unitCnt++) {

                for (int i = 0; i < unitLength; i++) {
                    currentRow += moveY[directionOrder[directionIdx]];
                    currentCol += moveX[directionOrder[directionIdx]];
                    idxForMap++;
                    locationIdxMap.put(new Location(currentRow, currentCol), idxForMap);
                    beadList.add(arr[currentRow][currentCol]);
                    if(currentRow==0 && currentCol ==0 ) break;  //////
                }
                if(currentRow==0 && currentCol ==0 ) break; ///////
                directionIdx++;
                if (directionIdx == 4) directionIdx = 0;
            }
            if(currentRow==0 && currentCol ==0 ) break; ////// 과연 이게 맞는 건가...
            unitLength++;

        }

        /*
        System.out.println(beadList.size());

        for( Integer bead : beadList ){
            System.out.print(bead + " ");
        }


        for( Map.Entry<Location,Integer> entry : locationIdxMap.entrySet() ){
            System.out.println(entry.getKey().toString() + " " +  entry.getValue());
        }
        */



        // trialList를 반복하면서 한 trial 당 진행해야하는 4가지 절차를 반영한다.
        for(TrialInfo trialInfo : trialInfoList) {

            int selectedDirectionIdx = trialInfo.getDirection();
            int selectedLength = trialInfo.getLength();

            currentRow = startRow;
            currentCol = startCol;


            // 1단계 : 블리자드로 죽이기
            List<Integer> selectedIdxList = new ArrayList<>();
            for (int i = 0; i < selectedLength; i++) {
                currentRow += moveY[selectedDirectionIdx];
                currentCol += moveX[selectedDirectionIdx];
                selectedIdxList.add(locationIdxMap.get(new Location(currentRow, currentCol)));
            }
            Collections.sort(selectedIdxList, Collections.reverseOrder());
            for (int selectedIdx : selectedIdxList) {
                //System.out.println(selectedIdx);
                beadList.remove(selectedIdx);
            }

            // 2단계 : 순회하면서 폭발하기
            int exploadCnt ;
            do {
                exploadCnt = 0;
                int beadCnt = 0;
                for (int i = 1; i < beadList.size(); i++) {
                    if (beadList.get(i) != beadList.get(i - 1) || i == beadList.size() - 1) {
                        if(beadList.get(i-1)==0) continue;
                        if (beadCnt >= 4) {
                            exploadCnt ++;
                            beadExploadCnt[beadList.get(i-1)] +=beadCnt;
                            for (int j = 0; j < beadCnt; j++) {
                                beadList.remove((--i));
                            }
                        }
                        beadCnt = 1;
                    } else {
                        beadCnt++;
                    }
                }
            } while (exploadCnt != 0);

            // 3단계 : 생성하기
            int beadCnt=1;
            for(int i=1; i<beadList.size() ; i++){
                int prev=beadList.get(i-1);
                int current = beadList.get(i);
                if(prev ==0) continue;
                if(prev!=current){
                    if(prev==-1) continue;
                    for(int j=0; j<beadCnt; j++ ){
                        beadList.remove(--i);
                    }
                    beadList.add(i++,beadCnt);
                    beadList.add(i++,prev);
                    beadCnt=1;
                }else beadCnt ++;
            }
            //3단계 2: 49 이상에서 삭제
            int bound = size*size;
            while(beadList.size()>bound+1){
                 beadList.remove(beadList.size()-1);
            }
            while(beadList.size()<bound+1){
                beadList.add(0);
            }

        }




        int answer =0;
        for(int i =1; i<beadExploadCnt.length; i++){
            answer += i*beadExploadCnt[i];
        }
        System.out.println(answer);

        //System.out.println(Arrays.toString(beadExploadCnt));

        /*
        System.out.println(beadList.size());

        for( Integer bead : beadList ){
            System.out.print(bead + " ");
        }

        System.out.println(Arrays.toString(beadExploadCnt));
        */

    }
}






















