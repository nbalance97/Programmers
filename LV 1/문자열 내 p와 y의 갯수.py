from collections import Counter
def solution(s):
    answer = True
    s = s.lower()
    counter = Counter(s)
    
    pc = counter.get('p')
    yc = counter.get('y')
    
    if pc == None and yc == None:
        return True
    elif pc == None or yc == None:
        return False
    else:
        if pc == yc:
            return True
        else:
            return False

    return True
