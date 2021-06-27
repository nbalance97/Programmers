def solution(n, words):
    word_said = set()
    
    answer = []
    
    last = ''
    for i, word in enumerate(words):
        if word in word_said or (len(last) != 0 and last[-1] != word[0]):
            answer = [(i%n)+1, (i//n)+1]
            break
        word_said.add(word)
        last = word
    
    if len(answer) == 0:
        answer = [0, 0]

    return answer
