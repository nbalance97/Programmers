import re
def solution(m, musicinfos):
    answer = ''
    
    infos = []
    
    # 시간 분단위로 변환 
    for musicinfo in musicinfos:
        info = musicinfo.split(',')
        stmin = 60 * int(info[0][0:2]) + int(info[0][3:5])
        fimin = 60 * int(info[1][0:2]) + int(info[1][3:5])
        title = re.findall('A#|C#|D#|F#|G#|[A|B|G|F|E|D|C]', info[3])
        it = (fimin - stmin) // len(title)
        k = (fimin - stmin) % len(title)
        infos.append([stmin, fimin, info[2], title * it + title[:k]])
    
    # 재생시간, 시작시간 순 정렬
    infos.sort(key=lambda x:(-(x[1]-x[0]), x[0]))
    m = re.findall('A#|C#|D#|F#|G#|[A|B|G|F|E|D|C]', m)
    length = len(m)
    
    # 문자열 비교 파트
    for i in range(len(infos)):
        print(infos[i])
        for j in range(len(infos[i][3]) - length + 1):
            count = 0
            for k in range(len(m)):
                if m[k] == infos[i][3][j+k]:
                    count += 1
                    
            if count == length:
                answer = infos[i][2]
                break
                
        if answer != '':
            break
                
        
    if answer == '':
        answer = '(None)'

    return answer
