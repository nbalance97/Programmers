def solution(money):
    max_money = 0
    
    # 1번을 뽑았을 때
    a, b, c, d = 0, 0, 0, 0
    a, b = money[0], money[0]
    
    # 1번을 뽑지 않았을 때
    e, f, g, h = 0, 0, 0, 0
    e, f = 0, money[1]
    
    for i in range(2, len(money)):
        c = max(a, b)
        d = max(a + money[i], b)
        g = max(e, f)
        h = max(e + money[i], f)
        
        a, b = c, d
        e, f = g, h
        

    answer = max(a, e, f)
    return answer
