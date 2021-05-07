import sys
sys.setrecursionlimit(10**5)

def get_room(dic, num): # union-find의 find 방식과 비슷하게
    if num not in dic.keys():
        dic[num] = num + 1
        return num
    p = get_room(dic, dic[num]) # 빈 방 찾기위해 거쳐가는 모든 방의 다음 위치 수정
    dic[num] = p+1
    return p 

def solution(k, room_number):
    answer = []
    
    current = dict()
    
    for number in room_number:
        answer.append(get_room(current, number))

    return answer
