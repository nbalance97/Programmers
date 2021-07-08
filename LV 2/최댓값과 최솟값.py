def solution(s):
    answer = ''
    p = list(map(int, s.split()))
    p.sort()
    answer = str(p[0]) + ' ' + str(p[-1])
    
    return answer
