package com.interviewbit.hash.math;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnTheStraightLine {
    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x.isEmpty()){
            return 0;
        }
        HashMap<String,Integer> slope = new HashMap<String,Integer>();
        int max = 0;
        for(int i =0;i<x.size();i++){
            int x1 = x.get(i);
            int y1 = y.get(i);
            int duplicates = 0;
            int localMax = 0;
            slope.clear();
            for(int j=i+1;j<x.size();j++){
                String slp = "";
                int x2 = x.get(j);
                int y2 = y.get(j);
                if(x1==x2 && y1==y2){
                    duplicates++;
                    continue;
                }
                else if(x1==x2){
                    slp = "Vertical";
                }
                else if(y1==y2){
                    slp = "Horizontal";
                }
                else{
                    slp = String.valueOf((1.0)*(y2-y1)/(x2-x1));
                }
                int count = slope.getOrDefault(slp,0);
                slope.put(slp,count+1);
                localMax = Math.max(localMax, count+1);
            }
            localMax += duplicates;
            max = Math.max(localMax,max);
        }
        return max+1;
    }
}
