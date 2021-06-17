def getodd():
    list = [True] * 3001
    list[1] = False
    list[2] = True
    for i in range(2, 3001):
        if list[i] == False:
            continue
        
        for j in range(i+i, 3001, i):
            list[j] = False
    
    return list

def solution(nums):
    list = getodd()
    answer = 0
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j+1, len(nums)):
                if i == j or i == k or j == k:
                    continue
                s = nums[i] + nums[j] + nums[k]
                if list[s] == True:
                    answer += 1
    return answer
