def solution(arr):
    answer = []
    if len(arr) == 1:
        answer = [-1]
    else:
        m = min(arr)
        arr.remove(m)
        answer = arr
    return answer
