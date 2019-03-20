package edu.whu.swe.lxl.learn.dp;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTrangle {
    public static void main(String[] args){
        int nRow=5;
        List<Integer> row=new ArrayList<>();
        row.add(1);
        for(int i=0;i<nRow-1;i++){
            row=nextRow(row);
        }
        for(int e:row){
            System.out.print(e);
        }
    }

    public static List<Integer> nextRow(List<Integer> lastRow) {
        List<Integer> nextRow = new ArrayList<>();
        int countOfLastRow = lastRow.size();
        nextRow.add(1);
        for (int i = 0; i < countOfLastRow - 1; i++) {
            int e = lastRow.get(i) + lastRow.get(i + 1);
            nextRow.add(e);
        }
        nextRow.add(1);
        return nextRow;

    }
}
