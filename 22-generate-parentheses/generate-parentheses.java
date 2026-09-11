class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(0, 0, n, "", ans);
        return ans;
    }

    void solve(int open, int close, int n, String curr, List<String> ans) {
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        if (open < n) {
            solve(open + 1, close, n, curr + "(", ans);
        }

        if (close < open) {
            solve(open, close + 1, n, curr + ")", ans);
        }
    }
}