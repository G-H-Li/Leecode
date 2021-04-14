package lanqiaocup.CupSix;

import java.util.Scanner;
//简单直接交换排序
public class Buttom {
    static int result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        in.close();
        result = 0;
        directSelectSort(nums);
        System.out.println(result);
    }
    
    public static int[] directSelectSort(int[] nums) {
        int n = nums.length;
        int index;
        for(int i=0; i<n-1; i++){
            index = i;
            for(int j=i; j<n; j++){
                if(nums[index] > nums[j]){
                    index = j;
                }
            }
            if(index != i){
                result += 1;
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        return nums;
    }
}
