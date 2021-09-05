from collections import deque

def bfs(numbers, target):
    queue = deque()
    queue.append([numbers[0], 1])
    queue.append([-numbers[0], 1])
    answer = 0
    while queue:
        currentSum, idx = queue.popleft()
        if idx == len(numbers):
            if currentSum == target:
                answer += 1
            continue
        queue.append([currentSum + numbers[idx], idx+1])
        queue.append([currentSum - numbers[idx], idx+1])
    
    return answer

def dfs(numbers, currentSum, idx, target):
    if idx == len(numbers):
        if currentSum == target:
            return 1
        return 0
    
    return dfs(numbers, currentSum+numbers[idx], idx+1, target) + (
        dfs(numbers, currentSum-numbers[idx], idx+1, target)
    )

    
            
def solution(numbers, target):
    #return bfs(numbers, target)
    return dfs(numbers, 0, 0, target)
