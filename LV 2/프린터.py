import copy
from collections import deque

def solution(priorities, location):
    prior_copy = copy.deepcopy(priorities)
    prior_copy.sort()
    queue = deque()
    for i, pr in enumerate(priorities):
        queue.append([pr, i]) # 우선순위랑 해당 인덱스 같이 삽입
    answer = 0
    
    while queue:
        pr, idx = queue.popleft()
        if pr == prior_copy[-1]:
            answer += 1
            if idx == location:
                break
            prior_copy.pop()
        else:
            queue.append([pr, idx])

    return answer
