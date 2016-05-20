c class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);

        return result;
    }

    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }

            beg++;
            end--;
        }

        return true;
    }

    private void helper(String s, ArrayList<String> path, int pos,
            ArrayList<ArrayList<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String prefix = s.substring(pos, i + 1);
            if (!isPalindrome(prefix)) {
                continue;
            }

            path.add(prefix);
            helper(s, path, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
}