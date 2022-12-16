from collections import defaultdict

def solution(s):
    answer = []
    pos = defaultdict(lambda: -1)
    
    for i, ch in enumerate(s):
        if pos[ch] == -1:
            answer.append(-1)
        else:
            answer.append(i - pos[ch])
        pos[ch] = i
    
    return answer
