class Node {
    Node prev;
    int value;
    int min;

    public Node(Node prev, int value, int min) {
        this.prev = prev;
        this.value = value;
        this.min = min;
    }
}

class MinStack {
    public Node root;

    public MinStack() {
        root = null;
    }
    
    public void push(int val) {
        if (root == null) {
            root = new Node(null, val, val);
        } else {
            root = new Node(root, val, Math.min(root.min, val));
        }
    }
    
    public void pop() {
        root = root.prev;
    }
    
    public int top() {
        return root.value;
    }
    
    public int getMin() {
        return root.min;
    }
}
