

def solution(msg):
    words = {chr(i):idx+1 for idx, i in enumerate(range(ord('A'), ord('Z')+1))}
    posfrom = 0
    nextidx = 27
    answer = []
    nextpos = 0

    while True:
        check = False
        for i in range(posfrom+1, len(msg)+1):
            if words.get(msg[posfrom:i]) == None:
                check = True
                words[msg[posfrom:i]] = nextidx
                nextpos = i-1
                nextidx += 1
                break
        
        if check:
            answer.append(words[msg[posfrom:nextpos]])
        else:
            answer.append(words[msg[posfrom:]])
            break
        
        posfrom = nextpos          

    return answer
