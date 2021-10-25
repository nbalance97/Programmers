from itertools import permutations

def solution(k, dungeons):
    answer = -1
    total_index = [i for i in range(len(dungeons))]
    total_case = list(permutations(total_index, len(dungeons)))
    
    for each_case in total_case:
        fatigue = k
        dungeon_count = 0
        
        for dungeon_idx in each_case:
            if fatigue >= dungeons[dungeon_idx][0]:
                dungeon_count += 1
                fatigue -= dungeons[dungeon_idx][1]
        
        answer = max(answer, dungeon_count)
    
    return answer
