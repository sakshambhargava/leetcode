class Solution(object):
    def topKFrequent(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        d = collections.defaultdict(int)
        for word in words:
            d[str(word)] += 1

        # alternative ways to do that
        # d = collections.Counter(words)
        return [i[0] for i in sorted(d.items(), key = lambda x : (-x[1], x[0]))[:k]] # top K
        # return [w for w, v in sorted(collections.Counter(words).items(), key = lambda x: (-x[1], x[0])) [:k]]
