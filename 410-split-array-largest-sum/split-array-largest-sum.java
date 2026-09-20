class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPut(nums,k,mid)){
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;

        
    }
    private boolean canPut(int[]nums,int k,int subSum){
        int sum=0;
        int count=1;
        for(int n:nums){
            if(sum+n<=subSum){
                sum+=n;
            }
            else{
                count++;
                sum=n;
            }
        }
        return count<=k;
    }
}