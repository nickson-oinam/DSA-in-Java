class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length()>s2.length()) return false;

      Map<Character,Integer> map=new HashMap<>();

      for(char c: s1.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
      }
    
    int left=0;
    int count=s1.length();
    for(int right=0;right<s2.length();right++){
        char r=s2.charAt(right);
        int val=map.getOrDefault(r,0);
        if(val>0) count--;
        map.put(r,val-1);

        if(count==0) return true;


        if(right-left+1==s1.length()){
            char l=s2.charAt(left);
            int valleft=map.getOrDefault(l,0);
            if(valleft>=0) count++;
            map.put(l,valleft+1);
            left++;
        }
        
    }
        return false;
    }
}