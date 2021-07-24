from collections import deque

def solution(n, stations, w):
    answer = 0
    stations = deque(stations)
    x = 1
    while x <= n:
        range_x1, range_x2 = int(10e9), int(10e9)
        if stations:
            range_x1 = stations[0]-w
            range_x2 = stations[0]+w
        if x >= range_x1 and x <= range_x2:
        # 이미 설치된 기지국 안에 있는 경우, 기지국 밖으로 점프시켜줌.
            x = range_x2 + 1
            stations.popleft()
        else: # 현재 위치에 기지국 놓아야 하는 경우
            answer += 1
            # 현재 위치가 기지국의 가장 왼쪽에 닿았을 때, 다음 위치는 2 * w + 1칸 뒤다.
            x = x + (2 * w + 1) 
    return answer
