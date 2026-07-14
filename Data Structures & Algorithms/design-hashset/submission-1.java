class MyHashSet {
    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key, ListNode next) {
            this.key = key;
            this.next = next;
        }
    }

    private ListNode[] set;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public MyHashSet() {
        set = new ListNode[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(int key) {
        return (key & 0xfffffff) % set.length;
    }

    public void add(int key) {
        int index = hash(key);
        if (set[index] == null) {
            set[index] = new ListNode(-1, null);
        }

        ListNode current = set[index];
        while(current.next != null) {
            if (current.next.key == key) return;

            current = current.next;
        }

        current.next = new ListNode(key, null);
        size++;

        if ((double) size / set.length >= LOAD_FACTOR) {
            resize();
        }
        
    }

    public void remove(int key) {
        int index = hash(key);
        if (set[index] == null) {
            return;
        }

        ListNode current = set[index];
        while(current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                size--;
                return;
            }

            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        if (set[index] == null) {
            return false;
        }

        ListNode current = set[index];
        while(current.next != null) {
            if (current.next.key == key) return true;

            current = current.next;
        }

        return false;
    }

    private void resize() {
        ListNode[] oldSet = set;
        set = new ListNode[oldSet.length * 2];
        size = 0;

        for (ListNode node : oldSet) {
            if (node == null) continue;
            ListNode current = node.next;

            while (current != null) {
                add(current.key);
                current = current.next;
            }
        }
    }
}