class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);
        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
