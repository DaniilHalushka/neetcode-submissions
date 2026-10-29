class FreqStack {
    Map<Integer, Stack<Integer>> freqStack;
    Map<Integer, Integer> mapFreq;
    int maxFreq = 0;

    public FreqStack() {
        freqStack = new HashMap();
        mapFreq = new HashMap();
        maxFreq = 0;
    }

    public void push(int val) {
        int currentFreq = mapFreq.getOrDefault(val, 0) + 1;
        mapFreq.put(val, currentFreq);

        if (freqStack.containsKey(currentFreq) == false) {
            freqStack.put(currentFreq, new Stack());
        }

        freqStack.get(currentFreq).push(val);
        maxFreq = Math.max(currentFreq, maxFreq);
    }

    public int pop() {
        int result = freqStack.get(maxFreq).pop();
        mapFreq.put(result, mapFreq.get(result) - 1);

        if (freqStack.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return result;
    }
}