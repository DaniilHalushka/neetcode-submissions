//time: O(N)
//space: O(N)

//rewrite this version to O(1) space with Boyer-Moore majority voting algorithm


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int frequency = nums.length / 3;
        List<Integer> answer = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) > frequency) {
                answer.add(key);
            }
        }

        return answer;
    }
}