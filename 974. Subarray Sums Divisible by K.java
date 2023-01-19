class Solution {
    //O(N)time O(min(N,K))space
public int subarraysDivByK(int[] A, int K) {
    int[] map = new int[K];
    map[0] = 1;
    int count = 0, sum = 0;
    for (int a : A) {
        sum = (sum + a) % K;
        if (sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
        map[sum]++;
    }
    for (int m : map) {
        if (m == 0) continue;
        count += m * (m - 1) / 2;
    }
    return count;
}
        
    }
