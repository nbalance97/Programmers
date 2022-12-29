def solution(data, col, row_begin, row_end):
    data.sort(key = lambda x: (x[col-1], -x[0]))
    
    s = []
    
    for idx, each_data in enumerate(data):
        s.append(sum(map(lambda x:x % (idx+1), each_data)))
    
    answer = s[row_begin-1]
    for p in range(row_begin, row_end):
        answer = answer ^ s[p]
    
    return answer
