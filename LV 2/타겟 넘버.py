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
            
def solution(numbers, target):
    return bfs(numbers, target)
