package lanqiaocup.CupSix;

import java.util.ArrayList;
import java.util.List;

public class Lego {
    static int result;
    public static void main(String[] args) {
        int[] source = {1,2,3,4,5,6,7,8,9};
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(0);
        result = 0;
        dfs(source, nums);
        System.out.println(result);
    }

    public static void dfs(int[] source, List<Integer> nums) {
        if(nums.size() == 10){
            for(int i=1; i<6; i++){
                if(i<=2){
                    if(nums.get(i+2)<nums.get(i) || nums.get(i+3)<nums.get(i)){
                        return;
                    }
                }else if(i>2){
                    if(nums.get(i+4)<nums.get(i) || nums.get(i+3)<nums.get(i)){
                        return;
                    }
                }
            }
            result += 1;
        }

        for(int i:source){
            if(nums.contains(i)) continue;
            List<Integer> tmp = new ArrayList<Integer>(nums);
            tmp.add(i);
            dfs(source, tmp);
        }
    }
    
}
