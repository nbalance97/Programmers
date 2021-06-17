def solution(absolutes, signs):
    answer = 0
    for i, ab in enumerate(absolutes):
        ab = ab if signs[i] == True else -ab
        answer = answer + ab
    
    return answer
