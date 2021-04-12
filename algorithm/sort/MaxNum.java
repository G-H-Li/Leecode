package algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxNum {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        StringBuffer result = new StringBuffer();
        List<String> numsList = new ArrayList<String>();
        
        for(int i:nums){
            numsList.add(Integer.toString(i));
        }

        numsList.sort(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int n = Math.min(s1.length(), s2.length());
                int c1,c2;
                for(int i=0; i<n; i++){
                    c1 = Integer.parseInt(s1.substring(i,i+1));
                    c2 = Integer.parseInt(s2.substring(i,i+1));
                    if(c1>c2){
                        return -1;
                    }else if(c1<c2){
                        return 1;
                    }
                }

                if(s1.length() == s2.length()){
                    return 0;
                }else if(s1.length() < s2.length()){
                    return compare(s1, s2.substring(s1.length()));
                }else{
                    return compare(s1.substring(s2.length()), s2);
                }
            }
        });

        if(numsList.get(0).equals("0")){
            return "0";
        } else{
            for(String i: numsList){
                result.append(i);
            }
            return result.toString();
        }
        
    }
}
