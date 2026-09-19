class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=1;
        int max=10000000;
        
        int ans=-1;
        
        while(low<=max){
            int mid=low+(max-low)/2;
            if(canspeed(dist,hour,mid)){
                ans=mid;
                max=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

        
    }
    private boolean canspeed(int []dist,double hour,int speed){
        double time=0;

        for(int i=0;i<dist.length-1;i++){
           time+=(dist[i]+speed-1)/speed;
        }
        time+=(double) dist[dist.length-1]/speed;

        return time<=hour;
    }
}