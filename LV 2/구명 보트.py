from collections import deque
def solution(people, limit):
    answer = 0
    people.sort()
    deq = deque(people)
    sumation = 0
    while deq:
        left = deq.popleft() # 남아있는 사람 중 최소 무게 한명 뺌
        right = 0
        
        while deq: # 최대 무게에서 순차적으로 내려가면서 최소 + 최대가 limit보다 작은 경우까지 반복
            right = deq.pop()
            if left + right <= limit:
                break
            else:
                answer += 1    

        answer += 1
            
            
    return answer
