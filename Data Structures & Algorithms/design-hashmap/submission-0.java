//not optimal, improve in the future

class MyHashMap {
    private int[] array;

    public MyHashMap() {
        array = new int[1000001];
        Arrays.fill(array, -1);
    }
    public void put(int key, int val) {
        array[key] = val;
    }
    public int get(int key) {
        return array[key];
    }
    public void remove(int key) {
        array[key] = -1;
    }
}