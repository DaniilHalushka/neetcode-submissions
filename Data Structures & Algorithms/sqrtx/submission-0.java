class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if ((long) middle * (long) middle == x) {
                return middle;
            } else if ((long) middle * (long) middle > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return right;
    }
}