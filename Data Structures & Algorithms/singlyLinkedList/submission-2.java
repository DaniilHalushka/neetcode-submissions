class ListNode {
        int value;
        ListNode next;

        //default constructor with single node
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }

        //main constructor for node in list
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }


class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        ListNode currentNode = head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null) return -1;
            currentNode = currentNode.next;  
        }

        return currentNode == null ? -1 : currentNode.value;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);

        newHead.next = head;
        head = newHead;

        if (tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);

        if (tail == null) {
            tail = newTail;
            head = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        
    }

    public boolean remove(int index) {
        if (index < 0 || head == null) return false;

        if (index == 0) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            return true;
        }

        ListNode currentNode = head;   

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode == null) return false;
            
        }

        if (currentNode.next == null) return false;
        if (currentNode.next == tail) tail = currentNode;


        currentNode.next = currentNode.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> listOfElements = new ArrayList<Integer>();

        ListNode currentNode = head;

        while (currentNode != null) {
            listOfElements.add(currentNode.value);
            currentNode = currentNode.next;
        } 

        return listOfElements;
    }
}
