class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] dirs = path.split("/");

        for (String dir : dirs) {
            switch (dir) {
                case ".", "" -> {
                    continue;
                }

                case ".." -> {
                    deque.pollLast();
                }

                default -> {
                    deque.addLast(dir);
                }
            }
        }

        return "/" + String.join("/", deque);
    }
}