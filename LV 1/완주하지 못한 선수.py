def solution(participant, completion):
    answer = ''
    dic = {}
    for k in completion:
        try:
            dic[k] = dic[k] + 1
        except:
            dic[k] = 1
    
    for p in participant:
        if dic.get(p) == None:
            answer = p
            break
        elif dic.get(p) == 0:
            answer = p
            break
        else:
            dic[p] = dic[p] - 1
    
            
    return answer
