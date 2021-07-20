from collections import deque

def convert(time):
    return 60 * int(time[:2]) + int(time[3:])

def solution(n, t, m, timetable):
    answer = -1
    cv_time = []
    
    for time in timetable:
        cv_time.append(convert(time))
            
    cv_time.sort()
    queue = deque(cv_time)
    time = convert("09:00")
    total_people = n * m
    people = 0
    
    for i in range(n):
        shuttle = time + (t * i) # 현재 도착한 셔틀 시간
        curr_count = 0
        # 현재 시간에 탑승가능한 인원 탑승
        while queue and queue[0] <= shuttle and curr_count < m:
            curr_count += 1
            # 현재 인원이 탑승했을 때, 최대 인원수가 된다면 1분 전에 서있어야 함
            if people + curr_count == total_people:
                answer = queue[0] - 1
                break
            queue.popleft()
        
        # 현재 인원수가 탑승가능 인원수보다 적다면 맞춰줌
        if curr_count < m:
            curr_count = m
            
        # 현재 셔틀에 못탔으나, 셔틀에 탑승가능하면서 마지막 셔틀이라면 도착시간에 타야 함 
        if answer == -1 and people + curr_count >= total_people:
            answer = time + (t * i)
        
        # 정답을 구했으면 break
        if answer != -1:
            break
                    
        people += curr_count
    
    if answer == -1:
        answer = time + (t * (n-1))
    
    # 시간 변환
    temp = answer
    answer = str(temp // 60).zfill(2)
    answer += ':'
    temp = temp % 60
    answer += str(temp).zfill(2)

    return answer
