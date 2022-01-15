from collections import defaultdict

def solution(id_list, report, k):
    reporter = defaultdict(lambda: set())
    mail_count = {i:0 for i in id_list}
    for log in report:
        fr, to = log.split()
        reporter[to].add(fr)
    
    for key in reporter.keys():
        if len(reporter[key]) >= k:
            for mail_target in reporter[key]:
                mail_count[mail_target] += 1
    
    answer = [mail_count[i] for i in id_list]
    
    return answer
