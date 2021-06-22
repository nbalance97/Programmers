def solution(numbers):
    answer = ''
    
    num = list(map(str, numbers))
    temp = []
    for i in num:
        if len(i) <= 4:
            temp.append([i * 3, len(i * 3) - len(i)])
    
    temp.sort(key=lambda x:(x[0], -x[1]), reverse=True)
    for t in temp:
        answer += t[0][:(len(t[0]) - t[1])]
        
    answer = str(int(answer))
    return answer
