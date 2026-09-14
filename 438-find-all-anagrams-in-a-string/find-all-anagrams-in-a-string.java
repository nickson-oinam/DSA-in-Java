class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        
        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> pMap=new HashMap<>();
        
        for(char c: p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }

        int left=0; int count=p.length();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);

            if(pMap.containsKey(ch) && sMap.get(ch)<=pMap.get(ch)){
                count--;
            }

            if(right-left+1> p.length()){
                char leftch=s.charAt(left);
                if(pMap.containsKey(leftch) && sMap.get(leftch)<=pMap.get(leftch)){
                count++;
            }
            sMap.put(leftch,sMap.get(leftch)-1);
            left++;
            

            }
            if(count==0){
                res.add(left);
            }
        }
        return res;
    }
}