package algorithm.sort;

public class InsertSort{
    
    public static void main(String[] args) {
        int[] nums = {9,5,3,2,1,4,6,7,8};
        int[] result = shellInsertSort(nums);
        for(int i: result){
            System.out.printf("%d ", i);
        }
    }

    /**
     * 直接插入排序，从无序区将数据依次插入有序区
     * @param nums
     * @return
     */
    public static int[] directInsertSort(int[] nums) {
        int n = nums.length;
        int j;
        //由于第一个位置是不需要进行排序的，直接从index=1开始
        for(int i=1; i<n; i++){
            int tmp = nums[i];
            for(j=i-1; j>=0&&tmp<nums[j]; j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = tmp;
        }
        return nums;
    }

    /**
     * 将直接插入排序的位置查找过程改为二分查找，提高一定效率
     * @param nums
     * @return
     */
    public static int[] binaryInsertSort(int[] nums) {
        int n = nums.length;
        int low, high, mid;
        for(int i=1; i<n; i++){
            int tmp = nums[i];
            //二分查找过程
            low=0; high=i-1;
            while(low<=high){
                mid = (low+high)>>1;
                if(tmp<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for(int k=i-1; k>=high+1; k--){
                nums[k+1] = nums[k];
            }

            nums[high+1] = tmp;
        }

        return nums;
    }

    /**
     * 希尔排序，又称分组排序，实则将数组每次划分小组，依次排序
     * @param nums
     * @return
     */
    public static int[] shellInsertSort(int[] nums) {
        int n = nums.length;
        int step = n >> 1;
        int j, tmp;
        // 修改step值
        while(step > 0){
            //对当前step的多个分组 进行排序
            for(int i=step; i<n; i++){
                tmp=nums[i];
                j = i- step;
                //分组内插入
                while(j>=0 && tmp<nums[j]){
                    nums[j+step] = nums[j];
                    j -= step;
                }
                nums[j+step] = tmp;
            }

            step = step >> 1;
        }

        return nums;
    }
}