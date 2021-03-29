package algorithm.dynamicPlanning;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 动态规划问题，关键找出公式
 */

 public class MaxSubArray{
     public static void main(String[] args) {
        int[] nums = new int[5];

        getMaxSubArray(nums);
     }

     public static int getMaxSubArray(int[] nums) {
        int pre = 0; int maxR = nums[0];
        for(int x: nums){
            pre = Math.max(x, x+pre);
            maxR = Math.max(pre, maxR);
        }
        return maxR;
     }
 }