import heapq

def solution(k, score):
    answer = []
    heap = []
    
    for s in score:
        if heap and s < heap[0] and len(heap) == k:
            answer.append(heap[0])
            continue
        
        if len(heap) == k:
            heapq.heappop(heap)
        heapq.heappush(heap, s)
        answer.append(heap[0])
    
    return answer
