class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            builder.append(str.length()).append('~').append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int i = 0;

        while (i < str.length()) {
            int separatorIndex = str.indexOf('~', i);
            int wordLength = Integer.parseInt(str.substring(i, separatorIndex));
            int startWordIndex = separatorIndex + 1;

            String word = str.substring(startWordIndex, startWordIndex + wordLength);
            result.add(word);

            i = startWordIndex + wordLength;
        }
        return result;
    }
}
