def solution(n, arr1, arr2):
    answer = []
    arr3 = []
    for t in range(n):
        temp = arr1[t] | arr2[t]
        temp = bin(temp)[2:]
        if len(temp) < n:
            temp = ('0' * (n-len(temp))) + temp
        temp = temp.replace('1', '#')
        temp = temp.replace('0', ' ')
        answer.append(temp)

    return answer
