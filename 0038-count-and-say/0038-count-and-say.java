class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
             while (j < result.length()) {
                int count = 1;
                while (j + 1 < result.length() &&
                       result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                next.append(count);
                next.append(result.charAt(j));
                j++;
            }

            result = next.toString();
        }

        return result;
    }
}
