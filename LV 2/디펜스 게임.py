import heapq

def solution(n, k, enemy):
    answer = 0
    heap = []
    
    soldiers, chance = n, k
    used_chance_count = 0
    for e in enemy:
        soldiers -= e
        heapq.heappush(heap, -e)
        
        while used_chance_count < chance and soldiers < 0:
            soldiers += -(heapq.heappop(heap))
            used_chance_count += 1
            
        if soldiers < 0:
            break
        
        answer += 1
        
    
    return answer
