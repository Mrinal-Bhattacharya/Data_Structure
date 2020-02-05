package com.interviewbit.hash.incrementalhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        int l = B.size();
        int w = B.get(0).length();
        int n = A.length();

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n < l*w){
            return result;
        }

        for(int left=0, right=l*w-1; left<n && right<n;left++,right++){
            String subString = A.substring(left, right+1);

            HashMap<String, Integer> strHashMap = new HashMap<>();
            boolean broke = false;
            for(int i=0; i<subString.length()/w;i++){
                String sub = subString.substring(i*w, i*w+w);
                if(strHashMap.containsKey(sub)){
                    int incrementedFreq = strHashMap.get(sub)+1;
                    strHashMap.put(sub, incrementedFreq);
                }else{
                    strHashMap.put(sub, 1);
                }
            }
            for(int i=0; i<l;i++){
                if(!strHashMap.containsKey(B.get(i)) || strHashMap.get(B.get(i)) == 0){
                    broke = true;
                    break;
                }else{
                    int derementedFreq = strHashMap.get(B.get(i))-1;
                    strHashMap.put(B.get(i), derementedFreq);
                }
            }
            if(broke){
                continue;
            }
            result.add(left);
        }
        return result;
    }
}
