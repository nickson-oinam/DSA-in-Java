class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pile:piles){
            right=Math.max(right,pile);
        }
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(caneat(piles,h,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
        
    }
    private boolean caneat(int[]piles,int h, int k){
        long hour=0;

        for(int p:piles){
            hour+=(p+k-1)/k;
        }
           return hour<=h;
    
    }
}