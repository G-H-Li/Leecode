package algorithm.sort;

public class SwapSort {
    public static void main(String[] args) {
        int[] nums = {9,5,3,2,1,4,6,7,8};
        int[] result = quickSort(nums, 0, nums.length-1);
        for(int i: result){
            System.out.printf("%d ", i);
        }
    }

    /**
     * 每次从无序区找到最小值挪动到有序区后面
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        int tmp;
        for(int i=0; i<n-1; i++){
            for(int j=n-1; j>i; j--){
                if(nums[j]<nums[j-1]){
                    tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp; 
                }
            }
        }

        return nums;
    }
    
    /**
     * 快速排序，在冒泡排序基础改进，选择一个数作为基数，每次将基数归位，基数两侧再次进行快排
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums, int start, int end) {
        int i=start, j=end;
        int tmp;
        if(i< j){
            tmp = nums[i];
            while(i != j){
                while(j>i && nums[j] >= tmp){
                    j--;
                }
                nums[i] = nums[j];
                while(i<j && nums[i] <= tmp){
                    i++;
                }
                nums[j] = nums[i];
            }

            nums[i] = tmp;
            quickSort(nums, start, i-1);
            quickSort(nums, i+1, end);

        }
        
        return nums;
    }
}
