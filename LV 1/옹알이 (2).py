from itertools import product


result = set()

def make_ch(st, available, last_used_index):
    if len(st) > 30:
        return
    
    result.add(st)
    
    for i in range(len(available)):
        if i == last_used_index:
            continue
        make_ch(st + available[i], available, i)

def solution(babbling):
    answer = 0
    words = ["aya", "ye", "woo", "ma"]
    make_ch("", words, -1)
    

    for b in babbling:
        if b in result:
            answer += 1
            
    return answer
