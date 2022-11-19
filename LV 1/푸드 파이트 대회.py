from collections import deque

def solution(food):
    deq = deque()
    deq.append("0")
    for i in range(len(food)-1, 0, -1):
        food_count = food[i] // 2
        food_ch = str(i) * food_count
        
        deq.appendleft(food_ch)
        deq.append(food_ch)
        
    answer = "".join(deq)
    return answer
