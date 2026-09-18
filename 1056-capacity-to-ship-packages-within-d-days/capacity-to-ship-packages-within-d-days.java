class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int max=0;
        for(int w:weights){
            low=Math.max(low,w);
            max+=w;
        }
        int ans=max;
       while(low<=max){
        int mid=low+(max-low)/2;
        if(canship(weights,days,mid)){
            ans=mid;
            max=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
        
    }
    private boolean canship(int [] weights,int days,int cap){
        int d=1;
        int curr=0;
        for( int wei:weights){
            if(curr+wei>cap){
                d++;
                curr=wei;
            }
            else{
                curr+=wei;
            }
        }
        return d<=days;
    }
}