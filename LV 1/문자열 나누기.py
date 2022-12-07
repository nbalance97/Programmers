def solution(st):
    answer = 0
    
    f, s = 0, 0
    t = None
    for ch in st:
        if t is None:
            t = ch
            f, s = 0, 0
        
        if ch == t:
            f += 1
        else:
            s += 1
        
        if f == s:
            answer += 1
            t = None
    
    if t is not None:
        answer += 1
        
    
    return answer
