def convert(s):
    return bin(s)[2:]

def solution(s):
    answer = []
    zero = 0
    step = 0
    while True:
        temp = []
        for n in s:
            if n == '0':
                zero += 1
            else:
                temp.append(n)
        
        t = convert(len(temp))
        step += 1
        s = t
        if s == '1':
            break
    
    answer = [step, zero]
    return answer
