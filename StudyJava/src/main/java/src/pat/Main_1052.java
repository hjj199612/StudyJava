package src.pat;


public class Main_1052   {
    /**
     * @param nums: Unordered array
     * @return: return the largest product
     */
    public void MaximumProduct() throws InterruptedException {


    }

        public static long MaximumProduct(int[] nums) {
        // write your code here
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[i]>nums[j]){
                    nums[i]=nums[i]+nums[j];
                    nums[j]=nums[i]-nums[j];
                    nums[i]=nums[i]-nums[j];
                }
            }
        }
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);
    }

    public static void main(String[] args) {
        int[] a={2,1,4,3};
        System.out.println(MaximumProduct(a));
    }
}