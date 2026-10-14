class MyQueue {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> helpStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        moveElement();
        return helpStack.pop();
    }

    public int peek() {
        moveElement();
        return helpStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty() && helpStack.isEmpty();
    }

    private void moveElement() {
        if (helpStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                helpStack.push(mainStack.pop());
            }
        }
    }
}