class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int element: nums) {
            if (map.containsKey(element)) return true;
            map.put(element, 1);
        }

        return false;
    }
}