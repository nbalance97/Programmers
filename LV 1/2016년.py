def solution(a, b):
    answer = ''
    month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    wk = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    day = 0
    for i in range(a):
        day = day + month[i]
    day = day + b - 1 # 1월 1일부터 시작하므로 1일 빼줌
    answer = wk[day % 7]

    return answer
