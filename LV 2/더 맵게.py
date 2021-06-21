import heapq

def solution(scoville, K):
    answer = 0
    heap = []
    for s in scoville:
        heapq.heappush(heap, s)

    while True:
        if heap[0] >= K:
            break
        if len(heap) == 1:
            answer = -1
            break
        t1 = heapq.heappop(heap)
        t2 = heapq.heappop(heap)
        t = t1 + t2*2
        heapq.heappush(heap, t)
        answer += 1
    
        
    return answer
