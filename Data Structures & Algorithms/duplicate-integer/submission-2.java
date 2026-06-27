class Solution {
    // HashSet contains unique elements, it's better than HashMap
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int element: nums) {
            if (set.contains(element)) return true;
            set.add(element);
        }

        return false;
    }
}