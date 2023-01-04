class Solution {
 public:
  int minimumRounds(vector<int>& tasks) {
    int ans = 0;
    unordered_map<int, int> count;

    for (const int task : tasks)
      ++count[task];
    for (const auto& [_, freq] : count)
      if (freq == 1)
        return -1;
      else
        ans += (freq + 2) / 3;
    return ans;
  }
};
