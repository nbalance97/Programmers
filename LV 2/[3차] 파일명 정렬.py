import re

def get_str(name):
    s = ""
    pos = 0
    for i in range(len(name)):
        if name[i].isdigit():
            pos = i
            break
        s += name[i]
    
    return (s, pos)

def get_num(name, start):
    pos = 0
    for i in range(start, len(name)):
        if not name[i].isdigit():
            pos = i
            break
            
    if pos == 0:
        pos = len(name)
    
    return pos

def solution(files):
    answer = []
    filelist = []
    for idx, file in enumerate(files):
        fileorg = file
        file = file.lower()
        head, src = get_str(file)
        dest = get_num(file, src)
        number = file[src:dest]
        filelist.append([head, number, fileorg, idx])
    
    filelist.sort(key=lambda x:(x[0], int(x[1]), x[3]))
    
    for f in filelist:
        answer.append(f[2])
        
    return answer
