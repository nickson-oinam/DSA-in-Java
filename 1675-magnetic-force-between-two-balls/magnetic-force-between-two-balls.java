class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1]-position[0];
        int ans=0;
       
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPut(position,m,mid)){
                ans=mid;
                low=mid+1;
                
            }
            else{
                high=mid-1;
            }
        } return ans;
        
    }
    private boolean canPut(int[] position,int m, int force){
        int first=position[0];
        int count=1;
        for(int i=1;i<position.length;i++){
            if(position[i]-first>=force){
                count++;
                first=position[i];
            }
        }
        return count>=m;
    }
}