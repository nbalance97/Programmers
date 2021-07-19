def convert(time):
    return 3600 * int(time[:2]) + 60 * int(time[3:5]) + int(time[6:8])

def r_convert(s):
    hour = str(s // 3600).zfill(2)
    s = s % 3600
    minite = str(s // 60).zfill(2)
    s = s % 60
    second = str(s).zfill(2)
    return hour + ":" + minite + ":" + second
    

def solution(play_time, adv_time, logs):
    answer = ''
    total = convert(play_time)
    advertise = convert(adv_time)
    consumers = [0] * (total+1)
    n = 0
    
    for log in logs:
        temp = log.split('-')
        consumers[convert(temp[0])] += 1
        consumers[convert(temp[1])] -= 1
        
    for i in range(1, total+1): # 현재 시점에서의 시청자 수
        consumers[i] += consumers[i-1]
    
    for i in range(1, total+1):
        consumers[i] += consumers[i-1]
    
    people = consumers[advertise-1]
    time = 0
    
    for start in range(0, total-advertise):
        if people < consumers[start+advertise] - consumers[start]:
            people = consumers[start+advertise] - consumers[start]
            time = start + 1
            
    answer = r_convert(time)
    
    return answer
