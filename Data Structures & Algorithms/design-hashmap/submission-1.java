class MyHashMap {
    private static class ListNode {
        int key, value;
        ListNode next;

        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private ListNode[] map;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        map = new ListNode[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % map.length;
    }

    public void put(int key, int value) {
        if ((double) size / map.length >= LOAD_FACTOR) {
            resize();
        }

        putNode(key, value);
    }

    private void putNode(int key, int value) {
        int index = hash(key);
        if (map[index] == null)
            map[index] = new ListNode(-1, -1, null);
        ListNode current = map[index];
        while (current.next != null) {
            if (current.next.key == key) {
                current.next.value = value;
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(key, value, null);
        size++;
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null)
            return -1;

        ListNode current = map[index].next;

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null)
            return;

        ListNode current = map[index];

        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                size--;
                return;
            }

            current = current.next;
        }
    }

    //note: change links in-place
    private void resize() {
        ListNode[] oldMap = map;
        map = new ListNode[oldMap.length * 2];
        size = 0;

        for (ListNode node : oldMap) {
            if (node == null)
                continue;

            ListNode current = node.next;
            while (current != null) {
                putNode(current.key, current.value);
                current = current.next;
            }
        }
    }
}