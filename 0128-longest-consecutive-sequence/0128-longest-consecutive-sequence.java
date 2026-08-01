class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int a;
        int count=0;
        for(int i=0;i<n;i++)
        {
            a=nums[i];
           map.put(a,map.getOrDefault(a,0)+1);
        }
        int longest=0;
        for(int key:map.keySet()){
            if(!map.containsKey(key-1)){
                count=1;
               int num=key;
                while(map.containsKey(num+1)){
                   num++;
                    count++;
                }

                longest = Math.max(longest, count);
            }

        }
        return longest;
    }
}