import re

def calculation(cmd):
    if cmd[0] == '1' and cmd[1] == '0': # 10인 경우는 한칸 미뤄버림
        score = 10
        cmd = cmd[1:]
    else:
        score = int(cmd[0])
        
    area = cmd[1]
    if area == 'S':
        score = score ** 1
    elif area == 'D':
        score = score ** 2
    elif area == 'T':
        score = score ** 3
    
    if len(cmd) > 2:
        special = cmd[2]
        if special == '*':
            score = score * 2
        elif special == '#':
            score = score * (-1)
            
    return score
    

def solution(dartResult):
    answer = 0
    temp = re.findall(r'[0-9]+[S|D|T][*|#]*', dartResult)
    calc = [0] * len(temp)
    
    for i,tmp in enumerate(temp):
        calc[i] = calculation(tmp)
        if i != 0 and len(tmp) > 2 and tmp[2] == '*':
            calc[i-1] = calc[i-1] * 2 # 이전 점수 두배
        
    answer = sum(calc)
    return answer
