class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstocc(nums,target);
        int last=lastocc(nums,target);
        return new int[]{first,last};
        
    }
    private int firstocc(int nums[],int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                ans=mid;
                right=mid-1;
            }
            else if( target>nums[mid]){
                   left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    private int lastocc(int nums[],int target){
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                ans=mid;
                left=mid+1;
            }
            else if( target<nums[mid]){
                right=mid-1;
                
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}