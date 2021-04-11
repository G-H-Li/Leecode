package algorithm.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {9,5,3,2,1,4,6,7,8};
        int[] result = directSelectSort(nums);
        for(int i: result){
            System.out.printf("%d ", i);
        }
    }
    
    /**
     * 直接选择排序：每次从无序区选择最小值放有序区最后
     * @param nums
     * @return
     */
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
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        return nums;
    }

    //TODO 堆排序
    /**
     * 堆排序：挖个坑，先不写
     * @param nums
     * @return
     */
    public static int[] heapSort(int[] nums) {
        return nums;
    }
}
