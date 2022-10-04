class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        events = []
        for L, R, H in buildings:
            events.append((L, -H, R)) 
            events.append((R, 0, 0))
        events.sort()
        
        res = [(0, 0)]
        heap = [(0, float('inf'))]
        
        for pos, negH, R in events:
            while heap[0][1] <= pos:
                heapq.heappop(heap)
            if negH != 0:
                heapq.heappush(heap, (negH, R))
            if res[-1][1] != -heap[0][0]:
                res.append([pos, -heap[0][0]])
        return res[1:]
