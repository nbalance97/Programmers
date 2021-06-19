def solution(s):
    answer = ''
    count = 0
    for c in s:
        if c == " ":
            count = 0
            answer += c
        else:
            if count % 2 == 0:
                answer += c.upper()
            else:
                answer += c.lower()
            count += 1
    
    return answer
