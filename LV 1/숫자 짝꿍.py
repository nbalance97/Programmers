from collections import Counter

def solution(X, Y):
    count_x = [0] * 10
    count_y = [0] * 10
    
    answer = ""
    answer_flg = False
    
    for ch in X:
        count_x[int(ch)] += 1    
        
    for ch in Y:
        count_y[int(ch)] += 1
    
    for i in range(9, -1, -1):
        cnt = min(count_x[i], count_y[i])
            
        for j in range(cnt):
            answer += str(i)
    
    if len(answer) == 0:
        return "-1"
    
    if answer[0] == "0":
        return "0"
    
    return answer
