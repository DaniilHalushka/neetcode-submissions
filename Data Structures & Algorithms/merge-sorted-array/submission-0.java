class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer = m - 1;
        int secondPointer = n - 1;
        int insertionPointer = m + n - 1;

        while (firstPointer >= 0 && secondPointer >= 0) {
            if (nums1[firstPointer] <= nums2[secondPointer]) {
                nums1[insertionPointer] = nums2[secondPointer];
                secondPointer--;
            } else {
                nums1[insertionPointer] = nums1[firstPointer];
                firstPointer--;
            }

            insertionPointer--;
        }

        while (secondPointer >= 0) {
            nums1[insertionPointer] = nums2[secondPointer];
            insertionPointer--;
            secondPointer--;
        }
    }
}