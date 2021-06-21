def solution(progresses, speeds):
    answer = []
    progresses = progresses[::-1]
    speeds = speeds[::-1]
    
    while True:
        remainder = (100 - progresses[-1]) % speeds[-1]
        days = (100 - progresses[-1]) // speeds[-1] 
        if remainder != 0:
            days = days + 1
        
        for i in range(len(progresses)):
            progresses[i] = progresses[i] + speeds[i] * days

        count = 0
        while progresses and progresses[-1] >= 100:
            count += 1
            progresses.pop()
            speeds.pop()
        
        answer.append(count)
        if not progresses:
            break
    return answer
