def solution(genres, plays):
    answer = []
    count_hash = {key:0 for key in set(genres)}
    list_hash = {key:[] for key in set(genres)}
    
    for idx, genre in enumerate(genres):
        count_hash[genre] += plays[idx]
        list_hash[genre].append([plays[idx], idx])
    
    temp = list(count_hash.items())
    temp.sort(key = lambda x:x[1], reverse=True)
    for key, _ in temp:
        cnt_list = list_hash[key]
        cnt_list.sort(key = lambda x:(-x[0], x[1]))
        for i, (_, idx) in enumerate(cnt_list):
            answer.append(idx)
            if i == 1: # 두개만
                break
    
    return answer
