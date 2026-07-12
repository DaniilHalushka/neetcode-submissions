//Boyer-Moore majority voting algorithm modification
// time: O(N)
// space: O(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;

        for (int element : nums) {
            if (element == candidate1) {
                count1++;
            } else if (element == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = element;
                count1++;
            } else if (count2 == 0) {
                candidate2 = element;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int element : nums) {
            if (element == candidate1) {
                count1++;
            } else if (element == candidate2) {
                count2++;
            }
        }

        List<Integer> answer = new ArrayList<>();
        if (count1 > nums.length / 3) answer.add(candidate1);
        if (count2 > nums.length / 3) answer.add(candidate2);

        return answer;
    }
}