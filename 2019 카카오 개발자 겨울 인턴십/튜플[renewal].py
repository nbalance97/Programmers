def solution(s):
    answer = []
    import re
    temp = [set(p[1:-1].split(",")) for p in re.findall(r"{[0-9|,]*}", s[1:-1])]
    temp.sort(key = lambda x:len(x))
    answer.append(int(list(temp[0])[0]))
    for i in range(1, len(temp)):
        answer.append(int(list(temp[i] - temp[i-1])[0]))

    return answer
