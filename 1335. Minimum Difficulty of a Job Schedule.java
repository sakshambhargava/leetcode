class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) {
            return -1;
        }

        int[][] memo = new int[d + 1][n];

        for (int i = 0; i <= d; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(d, 0, jobDifficulty, memo);
    }

    private int dfs(int day, int index, int[] jobs, int[][] memo) {
        final int n = jobs.length;
        if (day == 0 && index == n) {
            return 0;
        }
        if (day == 0 || index == n) {
            return Integer.MAX_VALUE;
        }

        if (memo[day][index] != -1) {
            return memo[day][index];
        }

        int curMax = jobs[index];
        int min = Integer.MAX_VALUE;
        for (int i = index; i < n; i++) {
            curMax = Math.max(jobs[i], curMax);
            int temp = dfs(day - 1, i + 1, jobs, memo);
            if (temp != Integer.MAX_VALUE) {
                min = Math.min(min, temp + curMax);
            }
        }

        memo[day][index] = min;

        return min;
    }
}
