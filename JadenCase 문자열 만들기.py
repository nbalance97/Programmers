def solution(s):
    word = False
    answer = ''
    for i in s:
        if not word:
            if i.isdigit():
                answer += i
                word = True
            elif i == ' ':
                answer += i
                continue
            else:
                answer += i.upper()
                word = True
        else:
            if i == " ":
                answer += i
                word = False
            else:
                answer += i.lower()
                
                
    return answer
