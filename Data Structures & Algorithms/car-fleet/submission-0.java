class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] carInfo = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            carInfo[i][0] = position[i];
            carInfo[i][1] = speed[i];
        }

        Arrays.sort(carInfo, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> deque = new ArrayDeque<>();
        for (int[] car : carInfo) {
            double tta = (double) (target - car[0]) / car[1];

            if (deque.isEmpty() || tta > deque.peek()) {
                deque.push(tta);
            }
        }

        return deque.size();
    }
}