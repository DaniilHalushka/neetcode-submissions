class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = left + (right - left) / 2;
            long totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + middle - 1) / middle; // equation of ceil!!
            }

            if (totalHours <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
