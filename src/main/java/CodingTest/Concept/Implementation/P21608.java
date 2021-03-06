package CodingTest.Concept.Implementation;

import java.util.*;




class Info implements  Comparable<Info>{

    private int studentNumber;
    private int friendlyCnt;
    private int entryCnt;
    private int row;
    private int col;

    public Info(int studentNumber,int friendlyCnt, int entryCnt, int row, int col) {
        this.studentNumber = studentNumber;
        this.friendlyCnt = friendlyCnt;
        this.entryCnt = entryCnt;
        this.row = row;
        this.col = col;
    }

    public int getFriendlyCnt() {
        return friendlyCnt;
    }

    public int getEntryCnt() {
        return entryCnt;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public int compareTo(Info o){

        if(getFriendlyCnt() ==o.getFriendlyCnt() ){

            if(getEntryCnt() == o.getEntryCnt()){

                if(getRow() == o.getRow()){

                    return getCol() - o.getCol();

                }else  return getRow() - o.getRow();

            }else return  o.getEntryCnt() - getEntryCnt();


        }else return o.getFriendlyCnt() - getFriendlyCnt();


    }
}



public class P21608 {

    public static void main(String [] arg) {


        P21608 T = new P21608();
        Scanner scanner = new Scanner (System.in);

        int size = scanner.nextInt();
        int [][] classRoom = new int[size][size];

        int numOfStudent = size*size;
        Map<Integer, int []> map = new LinkedHashMap<>();

        for(int i =0 ; i <numOfStudent; i++){
            Integer student = scanner. nextInt();
            int [] arr = new int [4];
            for(int j=0; j<4; j++) arr[j]=scanner.nextInt();
            map.put(student, arr);
        }

        int answer = T.solution(map, classRoom, size);
        System.out.println(answer);
    }


    public  int solution(Map<Integer, int []> map,  int [][] classRoom , int size ) {

        List<Info> selectedInfoList = new ArrayList<>();

        for (Map.Entry<Integer, int[]> student : map.entrySet()) {

            // ??? ????????? ?????? ?????? ???????????????
            List<Info> tempInfoList = new ArrayList<>();

            // ????????? ??????????????? ?????????????????? ???????????????.
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {

                    if (classRoom[row][col] != 0) continue;
                    else {

                        // ?????? ???????????????
                        List<Integer> nearInfo = new ArrayList<>();
                        if (col >= 1) nearInfo.add(classRoom[row][col - 1]);
                        if (col < size - 1) nearInfo.add(classRoom[row][col + 1]);
                        if (row >= 1) nearInfo.add(classRoom[row - 1][col]);
                        if (row < size - 1) nearInfo.add(classRoom[row + 1][col]);

                        //?????? ?????????
                        int friendlyCnt = 0;
                        int emptyCnt = 0;

                        // ??????????????? ????????????
                        for (Integer near : nearInfo) {
                            if (near == 0) {   // ????????? ?????????
                                emptyCnt++;
                                continue;
                            }
                            for (int ele : student.getValue()) {
                                if (near == ele) friendlyCnt++; //?????????????????????
                            }
                        }


                        tempInfoList.add(new Info(student.getKey(), friendlyCnt, emptyCnt, row, col));
                    }
                }
            }

            // ?????????????????? ??????????????? ????????? ????????? ????????????.
            Collections.sort(tempInfoList);
            Info selected = tempInfoList.get(0);
            selectedInfoList.add(selected);
            classRoom[selected.getRow()][selected.getCol()] = student.getKey();

        }

        int answer = 0;


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                // ?????? ???????????????
                List<Integer> nearInfo = new ArrayList<>();
                if (col >= 1) nearInfo.add(classRoom[row][col - 1]);
                if (col < size - 1) nearInfo.add(classRoom[row][col + 1]);
                if (row >= 1) nearInfo.add(classRoom[row - 1][col]);
                if (row < size - 1) nearInfo.add(classRoom[row + 1][col]);

                //?????? ?????????
                int friendlyCnt = 0;
                // ??????????????? ????????????
                for (Integer near : nearInfo) {
                    for (int ele : map.get(classRoom[row][col])) {
                        if (near == ele) friendlyCnt++; //?????????????????????
                    }
                }
                if(friendlyCnt==0) answer+=0;
                if(friendlyCnt==1) answer+=1;
                if(friendlyCnt==2) answer+=10;
                if(friendlyCnt==3) answer+=100;
                if(friendlyCnt==4) answer+=1000;
            }
        }


        return answer;
    }
}
