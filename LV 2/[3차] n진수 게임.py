def convert(num, scale):
    match = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F']
    
    if num == 0:
        return '0'
    
    result = ''
    while num > 0:
        result = match[num % scale] + result
        num = num // scale
    
    return result

def solution(n, t, m, p):
    answer = ''
    temp = ' '
    for i in range(0, 100000): # 여유있게 10만개정도 변환해서 붙여둠
        temp += convert(i, n)
        
    for i in range(p, len(temp), m): # 문자열 붙임
        answer = answer + temp[i]
        if len(answer) == t:
            break
            
    return answer
