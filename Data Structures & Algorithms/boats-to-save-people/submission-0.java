class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length <= 1)
            return 1;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boatsQuantity = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boatsQuantity++;
        }

        return boatsQuantity;
    }
}
