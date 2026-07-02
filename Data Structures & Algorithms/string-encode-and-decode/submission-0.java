public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strings) {
        StringBuilder encodedString = new StringBuilder();
        for (String string : strings) {
            encodedString.append(string.length()).append("#").append(string);
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String string) {
        List<String> decodedStrings = new ArrayList<>();
        int index = 0;

        //Iterate through encoded string
        while (index < string.length()) {

            // Find the delimiter to determine the length of the string.
            int delimiterIndex = string.indexOf("#", index);
            int stringLength = Integer.parseInt(string.substring(index, delimiterIndex));

            // Advance the index past the length and delimiter.
            index = delimiterIndex + 1;

            //Extract the next string using stringLength and starting from index
            String nextString = string.substring(index, index + stringLength);
            decodedStrings.add(nextString);

            //Increment the index by the extracted strings length
            index += stringLength;
        }
        return decodedStrings;
    }
}