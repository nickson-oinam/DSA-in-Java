class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if( (long) m*k>n) return -1;
        int low=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int bloom:bloomDay){
            low=Math.min(bloom,low);
            max=Math.max(bloom,max);
        }
        int ans=-1;
        while(low<=max){
            int mid=low+(max-low)/2;
            if(canBloom(bloomDay,m,k,mid)){
                ans=mid;
                max=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    private boolean canBloom(int[]bloomDay,int m,int k, int day){
        int count=0;
        int bouquet=0;
        for(int b:bloomDay){
            if(b<=day){
                count++;
                if(count==k){
                    bouquet++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return bouquet>=m;
        
    }
}