class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean isAlive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (Math.abs(asteroids[i]) > stack.peek()) {
                    stack.pop();
                    continue;
                } else if (Math.abs(asteroids[i]) == stack.peek()) {
                    stack.pop();
                    isAlive = false;
                    break;
                } else {
                    isAlive = false;
                    break;
                }
            }

            if (isAlive) {
                stack.push(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}