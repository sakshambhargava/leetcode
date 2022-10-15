class Solution {
public:
  int getLengthOfOptimalCompression(string s, int k) {
    const int n = s.length();
    auto encode = [&]() -> int {
      char p = '$';
      int count = 0;
      int len = 0;
      for (char c : s) {
        if (c == '.') continue;
        if (c != p) {
          p = c;
          count = 0;
        }
        ++count;
        if (count <= 2 || count == 10 || count == 100)
          ++len;               
      }
      return len;
    };
    function<int(int, int)> dfs = [&](int start, int k) -> int {
      if (start == n || k == 0) return encode();
      int ans = n;
      for (int i = start; i < n; ++i) {
        char c = s[i];
        s[i] = '.'; // delete
        ans = min(ans, dfs(i + 1, k - 1));
        s[i] = c;
      }
      return ans;
    };
    return dfs(0, k);
  }
};
