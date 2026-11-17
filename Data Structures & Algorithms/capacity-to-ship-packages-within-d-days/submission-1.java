class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int middle = left + (right - left) / 2;

            int totalDays = 1;
            int load = 0;

            for (int weight : weights) {
                if (load + weight > middle) {
                    totalDays++;
                    load = 0;
                }

                load += weight;
            }

            if (totalDays <= days) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}