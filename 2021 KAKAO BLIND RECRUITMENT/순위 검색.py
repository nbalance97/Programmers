from itertools import combinations
from bisect import bisect_left

def set_all_case(info):
    tot = []
    for i in range(5):
        cases = combinations([0, 1, 2, 3], i);
        for case in cases:
            key = ''
            for k in range(4):
                if k in case:
                    key = key + info[k]
                else:
                    key = key + "-"
            tot.append(key)
    
    return tot
  
def solution(info, query):
    answer = []
    inf_dict = {}
    
    for inf in info:
        temp = inf.split()
        total = set_all_case(temp)
        for case in total:
            if inf_dict.get(case) == None:
                inf_dict[case] = [int(temp[-1])]
            else:
                inf_dict[case].append(int(temp[-1]))
    
    for key in inf_dict.keys():
        inf_dict[key].sort()
    
        
    for que in query:
        temp = [p for p in que.split(" ") if p != "and"]
        find_score = int(temp[-1])
        key = "".join(temp[:-1])
        
        if key not in inf_dict.keys():
            answer.append(0)
        else:
            scores = inf_dict[key]
            answer.append(len(scores) - bisect_left(scores, find_score))

    return answer
