from collections import deque

def solution(skill, skill_trees):
    answer = 0
    for sk in skill_trees:
        queue = deque(skill)
        flag = True
        for s in sk:
            if s in queue:
                if queue[0] == s: # 선행스킬이면 큐에서 빼줌
                    queue.popleft()
                else: # 선행스킬이 아니라면 잘못된 것이므로 false
                    flag = False
                    break
        
        if flag:
            answer += 1
                    
    return answer
