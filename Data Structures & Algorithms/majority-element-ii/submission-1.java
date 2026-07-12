class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.size() > 2) {
                HashMap<Integer, Integer> modifiedMap = new HashMap<>();
                for (int key : map.keySet()) {
                    if (map.get(key) > 1) {
                        modifiedMap.put(key, map.get(key) - 1);
                    }
                }

                map = modifiedMap;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int key : map.keySet()) {
            int frequency = 0;
            for (int num : nums) {
                if (num == key) {
                    frequency++;
                }
            }

            if (frequency > nums.length / 3) {
                answer.add(key);
            }
        }

        return answer;
        
    }
}