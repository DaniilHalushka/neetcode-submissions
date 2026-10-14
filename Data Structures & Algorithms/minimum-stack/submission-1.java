class MinStack {
    private Stack<Integer> stack;
    private Stack<int[]> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value < minStack.peek()[0]) {
            minStack.push(new int[] {value, 1});

        } else if (value == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()[0]) {
            minStack.peek()[1]--;
            if (minStack.peek()[1] == 0) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }
}
