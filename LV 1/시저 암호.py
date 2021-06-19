def solution(s, n):
    upgap = ord('Z') - ord('A') + 1
    logap = ord('z') - ord('a') + 1
    answer = ''
    for c in s:
        if c == ' ':
            answer += c
            continue
        
        if ord('A') <= ord(c) and ord('Z') >= ord(c):
            temp = ord(c) + n
            if temp > ord('Z'):
                temp = temp - upgap
        else:
            temp = ord(c) + n
            if temp > ord('z'):
                temp = temp - logap
                
        answer += chr(temp)
    return answer
