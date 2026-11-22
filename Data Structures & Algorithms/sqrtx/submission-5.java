class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int left = 0, right = x;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if ((long) middle * (long) middle == x) {
                return middle;
            } else if ((long) middle * (long) middle > x) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        
        return left - 1;
    }
}