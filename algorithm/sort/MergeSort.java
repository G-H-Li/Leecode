package algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {9,5,3,2,1,4,6,7,8};
        int[] result = merge(nums);
        for(int i: result){
            System.out.printf("%d ", i);
        }
    }

    public static int[] merge(int[] nums) {
        int n= nums.length; int i;
        for(int step=1; step<n; step*=2){
            for(i=0; i+2*step-1<n; i+=2*step){
                twoMerge(nums, i, i+step-1, i+2*step-1);
            }
            //如果数组最后剩余不足2*step，则将最后一个step与最后的进行归并
            if(i+step-1<n){
                twoMerge(nums, i, i+step-1, n-1);
            }
        }
        return nums;
    }

    /**
     * 二路归并，将一个数组分为两个有序部分，low-mid，mid+1-high，将两个有序部分归并成一个有序数组
     * @param nums 数组
     * @param low 
     * @param mid
     * @param high
     * @return
     */
    public static int[] twoMerge(int[] nums, int low, int mid, int high) {
        int i=low, j=mid+1, k=0;
        int[] temp = new int[high-low+1];
        while(i<=mid && j<=high){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }else{
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = nums[i];
            i++;k++;
        }
        while(j<=high){
            temp[k] = nums[j];
            j++; k++;
        }
        k=0;i=low;
        while(i<=high){
            nums[i] = temp[k];
            i++;k++;
        }
        return nums;
    }
    
}
