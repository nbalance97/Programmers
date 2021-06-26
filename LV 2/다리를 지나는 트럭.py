from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    idx = 0
    cur_weight = 0
    time = 0
    queue = deque()
    while True:
        if queue and queue[0][1] <= time:
            cur_weight = cur_weight - queue[0][0]
            queue.popleft()
            
        if idx < len(truck_weights) and weight >= cur_weight + truck_weights[idx]: 
            queue.append([truck_weights[idx], time+bridge_length])
            cur_weight = cur_weight + truck_weights[idx]
            idx += 1
            
        time += 1
        if idx == len(truck_weights) and not queue:
            break
        
    answer = time
    return answer
