class Solution {
    public String decodeString(String s) {
        Deque<Integer> countDeque = new ArrayDeque<>();
        Deque<StringBuilder> stringDeque = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (char symbol : s.toCharArray()) {
            switch (symbol) {
                case '[' -> {
                    countDeque.push(currentCount);
                    stringDeque.push(currentString);

                    currentString = new StringBuilder();
                    currentCount = 0;
                }

                case ']' -> {
                    int repeat = countDeque.pop();
                    StringBuilder tempString = stringDeque.pop();

                    for (int i = 0; i < repeat; i++) {
                        tempString.append(currentString);
                    }

                    currentString = tempString;
                }

                default -> {
                    if (Character.isDigit(symbol)) {
                        currentCount = currentCount * 10 + (symbol - '0');
                    } else {
                        currentString.append(symbol);
                    }
                }
            }
        }

        return currentString.toString();
    }
}