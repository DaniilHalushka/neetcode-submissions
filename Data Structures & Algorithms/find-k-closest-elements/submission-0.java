//sliding window approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        int leftDistance = 0, rightDistance = 0;

        while (right - left + 1 > k) {
            leftDistance = Math.abs(arr[left] - x);
            rightDistance = Math.abs(arr[right] - x);

            if (leftDistance > rightDistance) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
