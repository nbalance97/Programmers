from collections import deque
def solution(progresses, speeds):
    answer = []
    progresses = deque(progresses)
    speeds = deque(speeds)
    while progresses:
        # 맨 왼쪽 작업이 몇일 걸리는지 파악
        days = (100 - progresses[0]) // (speeds[0])
        days = days + 1 if (100 - progresses[0]) % speeds[0] != 0 else days
        
        # 맨 왼쪽 작업이 종료되었을 때, 연쇄적으로 종료될수 있는 작업들 종료시키고 갯수 저장
        count = 0
        while progresses and (100 - progresses[0]) <= speeds[0] * days:
            count += 1
            progresses.popleft()
            speeds.popleft()
        
        answer.append(count)
    return answer


# def solution(progresses, speeds):
#     answer = []
#     progresses = progresses[::-1]
#     speeds = speeds[::-1]
    
#     while True:
#         remainder = (100 - progresses[-1]) % speeds[-1]
#         days = (100 - progresses[-1]) // speeds[-1] 
#         if remainder != 0:
#             days = days + 1
        
#         for i in range(len(progresses)):
#             progresses[i] = progresses[i] + speeds[i] * days

#         count = 0
#         while progresses and progresses[-1] >= 100:
#             count += 1
#             progresses.pop()
#             speeds.pop()
        
#         answer.append(count)
#         if not progresses:
#             break
#     return answer
