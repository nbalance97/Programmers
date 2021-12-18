def convert(number):
    return bin(number)[2:].zfill(101)[::-1]

def f(number):
    original = list(convert(number))
    target = list(convert(number + 1))
    difCount = 0
    for i in range(len(target)):
        if original[i] != target[i]:
            difCount += 1
    
    if difCount <= 2:
        return number + 1
    
    for i in range(len(target)):
        if original[i] != target[i]:
            target[i] = original[i]
            difCount -= 1
            if difCount <= 2:
                break
                
    return int("".join(target[::-1]), 2)
    
def solution(numbers):
    answer = list(map(lambda x: f(int(x)), numbers))
    return answer
